package oj.hot200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q616 {
    public String addBoldTag(String s, String[] dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(Arrays.asList(dict));
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; i++)
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    continue;
                }
        }
        int start = -1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == false) {
                if (start != -1) {
                    builder.append("<b>");
                    builder.append(s.substring(start - 1, i - 1));
                    builder.append("</b>");
                    builder.append(s.charAt(i - 1));
                }
                start = -1;
                builder.append(s.charAt(i - 1));
            } else {
                if (start == -1) start = i;
            }
        }
        if (start > 0) {
            builder.append("<b>");
            builder.append(s.substring(start - 1, s.length() - 1));
            builder.append("</b>");
        }
        return builder.toString();

    }
}
