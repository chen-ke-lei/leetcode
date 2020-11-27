package oj.interview_tips;

public class Q01_06 {
    public String compressString(String S) {
        if (S.length() <= 1) return S;

        String res = "";
        int len = 0;
        char lastC = '\0';
        for (int i = 0; i < S.length(); i++) {
            if (len == 0) {
                lastC = S.charAt(i);
                len++;
            } else if (lastC == S.charAt(i)) {
                len++;
            } else {
                res += (lastC + "" + len);
                len = 1;
                lastC = S.charAt(i);
            }
        }
        if (len > 0) res += (lastC + "" + len);
        return res.length() >= S.length() ? S : res;
    }

    public static void main(String[] args) {
        System.out.println(new Q01_06().compressString("aabcccccaaa"));
    }
}
