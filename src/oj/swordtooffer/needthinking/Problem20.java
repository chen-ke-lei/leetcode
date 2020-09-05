package oj.swordtooffer.needthinking;

public class Problem20 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean sign = false, e = false, dot = false, number = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (dot)
                    return false;
                dot = true;
                number = false;
            } else if (c == 'e' || c == 'E') {
                if (e || !number)
                    return false;
                number = false;
                sign = false;
                e = true;
            } else if (c == '+' || c == '-') {
                if (sign || number || (e && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'))) return false;
                sign = true;
                number = false;

            } else if (c >= '0' && c <= '9') {
                number = true;
            } else {
                return false;
            }
        }
        if (!number)
            return false;
        return true;
    }
}
