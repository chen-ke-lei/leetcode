package oj.top100.review01;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(res, 0, n, new StringBuilder());
        return res;
    }

    void dfs(List<String> res, int stack, int n, StringBuilder builder) {
        if (stack == 0 && n == 0) {
            res.add(builder.toString());
            return;
        }
        if (stack > 0) {
            builder.append(")");
            dfs(res, stack - 1, n - 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (n > stack) {
            builder.append("(");
            dfs(res, stack + 1, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
