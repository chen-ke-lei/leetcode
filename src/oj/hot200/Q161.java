package oj.hot200;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(t.length() - s.length()) >= 2) return false;
        if (s.length() == t.length()) {
            boolean fix = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (fix) fix = false;
                    else return false;
                }
            }
        } else {
            String longStr = s.length() > t.length() ? s : t;
            String shortStr = longStr == s ? t : s;
            int bit = 0;
            for (int i = 0; i < shortStr.length(); i++) {
                if (shortStr.charAt(i) != longStr.charAt(bit + i)) {
                    bit++;
                    if (bit > 1) break;
                }
            }
            if (bit > 1) {
                bit = 1;
                for (int i = 0; i < shortStr.length(); i++) {
                    if (shortStr.charAt(i) != longStr.charAt(bit + i)) return false;
                }
            }
        }

        return true;
    }
}
