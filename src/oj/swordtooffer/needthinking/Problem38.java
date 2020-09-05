package oj.swordtooffer.needthinking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem38 {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[0];
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        dfs(res, list, s);
        Set<String> set = new HashSet<>(res);
        String[] resString = new String[set.size()];
        int i = 0;
        for (String s1 : set) resString[i++] = s1;
        return resString;
    }

    void dfs(List<String> res, List<Character> characters, String s) {
        if (s.length() == 1) {
            characters.add(s.charAt(0));
            res.add(list2Str(characters));
            characters.remove(characters.size() - 1);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
            dfs(res, characters, (i > 0 ? s.substring(0, i) : "") + (i < s.length() - 1 ? s.substring(i + 1) : ""));
            characters.remove(characters.size() - 1);
        }

    }

    String list2Str(List<Character> list) {
        StringBuffer buffer = new StringBuffer();
        for (char c : list)
            buffer.append(c);
        return buffer.toString();
    }
}
