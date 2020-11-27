package oj.hot200;

public class Q1180 {
    public int countLetters(String S) {
        if (S.length() <= 1) return S.length();
        char last = S.charAt(0);
        int len = 1;
        int res = 0;
        for (int i = 1; i < S.length(); i++) {
            if (last == S.charAt(i)) {
                len++;
            } else {
                res += (1 + len) * len / 2;
                len = 1;
                last = S.charAt(i);
            }
        }
        res += (1 + len) * len / 2;
        return res;
    }
}
