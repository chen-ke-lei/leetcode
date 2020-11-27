package oj.interview_tips;

import java.util.HashSet;
import java.util.Set;

public class Q01_01 {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
