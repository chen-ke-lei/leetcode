package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q293 {
    public List<String> generatePossibleNextMoves(String s) {
        if (s.length() < 2) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                if (last == '+') {
                    res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
                } else {
                    res.add(s.substring(0, i - 1) + "++" + s.substring(i + 1));
                }
            }
            last = s.charAt(i);
        }
        return res;
    }
}
