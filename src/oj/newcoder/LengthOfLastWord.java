package oj.newcoder;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (res > 0)
                    return res;
            } else {
                res++;
            }
        }
        return res;
    }
}
