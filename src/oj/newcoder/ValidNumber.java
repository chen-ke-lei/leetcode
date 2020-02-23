package oj.newcoder;

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();
        if (s.length() == 0)
            return false;
        if (s.length() == 1 && (s.charAt(0) < '0' || s.charAt(0) > '9')) return false;
        boolean e = false, dot = false, number = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                if (!number || e)
                    return false;
                e = true;
                number = false;
                dot = true;
            } else if (s.charAt(i) == '.') {
                if (dot)
                    return false;
                dot = true;

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i!=0&&s.charAt(i-1)!='e')
                    return false;
                number = false;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
            else
                number = true;
        }
        if (!number)
            return false;
        return true;
    }
}
