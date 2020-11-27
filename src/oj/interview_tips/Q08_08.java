package oj.interview_tips;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q08_08 {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        dfs(res, new boolean[S.length()], new StringBuffer(), chars);

        return res.toArray(new String[res.size()]);
    }

    void dfs(List<String> res, boolean[] vis, StringBuffer buffer, char[] chars) {
        if (chars.length == buffer.length()) {
            res.add(buffer.toString());
            return;
        }
        char c = '\0';
        for (int i = 0; i < chars.length; i++) {
            if (vis[i] == false && c != chars[i]) {
                vis[i] = true;
                buffer.append(chars[i]);
                dfs(res, vis, buffer, chars);
                buffer.deleteCharAt(buffer.length() - 1);
                vis[i] = false;
                c = chars[i];
            }

        }
    }
}
