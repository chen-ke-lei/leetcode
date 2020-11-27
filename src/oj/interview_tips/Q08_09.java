package oj.interview_tips;

import java.util.ArrayList;
import java.util.List;

public class Q08_09 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, res, new StringBuffer());
        return res;
    }

    void dfs(int n, int stack, List<String> res, StringBuffer buffer) {
        if (n == 0 && stack == 0) res.add(buffer.toString());
        if (n > 0) {
            buffer.append("(");
            dfs(n - 1, stack+1, res, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (stack > 0) {
            buffer.append(")");
            dfs(n, stack - 1, res, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q08_09().generateParenthesis(3));
    }
}
