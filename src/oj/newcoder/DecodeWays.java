package oj.newcoder;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' > 0)
                res[i + 1] += res[i];
            if (s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10 <= 26 && s.charAt(i-1)!='0')
                res[i + 1] += res[i - 1];
            if (res[i + 1] == 0)
                return 0;
        }
        return res[res.length - 1];
    }
}
