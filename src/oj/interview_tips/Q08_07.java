package oj.interview_tips;

import java.util.ArrayList;
import java.util.List;

public class Q08_07 {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(res, new boolean[S.length()], new StringBuffer(), S);

        return res.toArray(new String[res.size()]);
    }

    void dfs(List<String> res, boolean[] vis, StringBuffer buffer, String s) {
        if (s.length() == buffer.length()) {
            res.add(buffer.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (vis[i] == false) {
                vis[i] = true;
                buffer.append(s.charAt(i));
                dfs(res, vis, buffer, s);
                buffer.deleteCharAt(buffer.length() - 1);
                vis[i] = false;
            }
        }
    }
}
