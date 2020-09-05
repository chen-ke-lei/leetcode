package oj.swordtooffer.needthinking;

public class Problem19 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (s.length() == 0) {
            if (p.length() != 2)
                return false;
            if (p.charAt(0) == '*' || p.charAt(1) != '*')
                return false;
            return true;
        }
        if (p.length() == 0)
            return false;

        boolean[] res = new boolean[s.length()];

        return res[res.length - 1];
    }
}
