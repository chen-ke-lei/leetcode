package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q269 {
    public String alienOrder(String[] words) {
        List<Integer> startIndex = new ArrayList<>();
        List<Integer>[] cList = new List[26];
        for (int i = 0; i < cList.length; i++) {
            cList[i] = new ArrayList<>();
        }
        boolean fix = true;
        int i = 0;
        while (fix) {
            fix = false;
            fill(cList);
            int sub = 0;
            int lastChar = '\0';
            startIndex.add(0);
            for (String word : words) {
                if (word.length() <= i) continue;
                fix = true;
                if (word.charAt(i) == lastChar) continue;
                lastChar = word.charAt(i);
                System.out.println(i+word);
                System.out.println(cList[lastChar - 'a']);
                if (cList[lastChar - 'a'].get(cList[lastChar - 'a'].size() - 1) != -1) return "";
                cList[lastChar - 'a'].set(cList[lastChar - 'a'].size() - 1, sub++);
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        fix = true;
        while (fix) {
            fix = false;
            boolean need = false;
            for (i = 0; i < 26; i++) {
                List<Integer> integers = cList[i];
                if (integers == null) continue;
                boolean corr = true;
                for (int j = 0; j < integers.size(); i++) {
                    if (integers.get(j) == -1) continue;
                    need = true;
                    if (integers.get(j) - startIndex.get(j) > 0) {
                        corr = false;
                        break;
                    }
                }
                if (corr) {
                    fix = true;
                    need = true;
                    cList[i] = null;
                    for (int j = 0; j < integers.size(); i++) {
                        if (integers.get(j) != -1) startIndex.set(j, startIndex.get(j) + 1);
                    }
                    break;
                }
            }
            if (need && !fix) return "";
        }

        return stringBuilder.toString();
    }

    void fill(List<Integer>[] cList) {
        for (List<Integer> integers : cList) {
            integers.add(-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q269().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
