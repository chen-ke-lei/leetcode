package oj.swordtooffer;

public class Problem67 {
    public int strToInt(String str) {
        long res = 0;
        boolean minus = false, numbers = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (numbers && (c < '0' || c > '9')) break;
            if (c == ' ') continue;
            else if (c == '+' || c == '-') {
                numbers = true;
                if (c == '-') minus = true;
            } else if (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                numbers = true;
            } else break;
            if (res > Integer.MAX_VALUE) {
                return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        res = minus ? -res : res;
        return (int) res;
    }
}
