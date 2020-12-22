package oj.top100.review01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
        public List<String> removeInvalidParentheses(String s) {
            Set<String> res = new HashSet<>();
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') left++;
                else if (s.charAt(i) == ')') {
                    if (left > 0) {
                        left--;
                    } else {
                        right++;
                    }
                }
            }
            dfs(res, s, new StringBuilder(), 0, 0, left, right);
            return new ArrayList<>(res);
        }

        void dfs(Set<String> res, String s, StringBuilder builder, int index, int stack, int leftCount, int rightCount) {
            if (index == s.length()) {
                if (stack == 0) {
                    res.add(builder.toString());
                }
                return;
            }
            if (s.charAt(index) != '(' && s.charAt(index) != ')') {
                builder.append(s.charAt(index));
                dfs(res, s, builder, index + 1, stack, leftCount, rightCount);
                builder.deleteCharAt(builder.length() - 1);
            } else if (s.charAt(index) == '(') {
                builder.append(s.charAt(index));
                dfs(res, s, builder, index + 1, stack + 1, leftCount, rightCount);
                builder.deleteCharAt(builder.length() - 1);
                if (leftCount > 0) {
                    dfs(res, s, builder, index + 1, stack, leftCount - 1, rightCount);
                }
            } else if (s.charAt(index) == ')') {
                if (stack > 0) {
                    builder.append(s.charAt(index));
                    dfs(res, s, builder, index + 1, stack - 1, leftCount, rightCount);
                    builder.deleteCharAt(builder.length() - 1);
                }
                if (rightCount > 0) {
                    dfs(res, s, builder, index + 1, stack, leftCount, rightCount - 1);
                }
            }
        }
}
