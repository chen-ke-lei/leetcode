package oj.newcoder;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        if (s.length() == 0) {
            if (!"*".equals(s) || p.length() != 0)
                return false;
        }
        boolean[] step = new boolean[s.length()];
        for(int i=0;i<s.length();i++){

        }
        return step[step.length - 1];
    }
}
