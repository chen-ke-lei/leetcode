package oj.top100.review01;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] dic = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(res, 0, digits, new StringBuilder());
        return res;
    }

    void dfs(List<String> res, int i, String digits, StringBuilder builder) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int index = digits.charAt(i) - '1';
        String tmp = dic[index];
        for (int i1 = 0; i1 < tmp.length(); i1++) {
            builder.append(tmp.charAt(i1));
            dfs(res, i + 1, digits, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
