package oj.hot200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q758 {
    public String boldWords(String[] words, String S) {
        List<int[]> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        for (String word : words) {
            set.add(word);
            maxLength = maxLength > word.length() ? maxLength : word.length();
            minLength = minLength < word.length() ? minLength : word.length();
        }
        for (int i = minLength - 1; i < S.length(); i++) {
            for (int j = Math.max(0, i - maxLength + 1); j <= i - minLength + 1; j++) {
                if (set.contains(S.substring(j, i + 1))) {
                    if (res.isEmpty() || res.get(res.size() - 1)[1]+1 < j) {
                        res.add(new int[]{j, i});
                    } else {
                        int[] tmp = new int[]{j, i};
                        while (!res.isEmpty() && tmp[0] <= res.get(res.size() - 1)[1]+1) {
                            int[] last = res.remove(res.size() - 1);
                            tmp[0] = Math.min(tmp[0], last[0]);
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        int index = 0;
        String resStr = "";
        for (int[] re : res) {
            resStr += S.substring(index, re[0]) + "<b>" + S.substring(re[0], re[1] + 1) + "</b>";
            index = re[1] + 1;
        }
        if (index < S.length())
            resStr += S.substring(index);
        return resStr;
    }

    public static void main(String[] args) {
        System.out.println(new Q758().boldWords(new String[]{"ccb", "b", "d", "cba", "dc"}
                , "eeaadadadc"));
    }
}
