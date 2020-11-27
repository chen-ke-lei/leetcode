package oj.hot200;

public class Q159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0 || s.length() <= 2) return s.length();
        char a = s.charAt(0), b = ' ';
        int start = 0, bE = -1, aE = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bE == -1) {
                bE = i;
                b = c;
            } else if (aE == -1) {
                aE = i;
                a = c;
            } else if (c == a) {
                aE = i;
            } else if (c == b) {
                bE = i;
            } else {
                res = res > i - start ? res : i - start;
                start = Math.min(bE, aE);
                if (start == aE) {
                    aE = i;
                    a = c;
                } else {
                    bE = i;
                    b = c;
                }
                start++;
            }
        }
        res = res > s.length() - start ? res : s.length() - start;
        return res;
    }
}
