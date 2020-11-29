package oj.top100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && set.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[res.length - 1];
    }
}
