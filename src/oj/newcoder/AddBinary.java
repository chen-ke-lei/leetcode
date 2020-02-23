package oj.newcoder;

public class AddBinary {
    public static void main(String[] av) {
        System.out.println(new AddBinary().addBinary("100", "110010"));
    }

    public String addBinary(String a, String b) {
        String res = "";
        String longS = a.length() > b.length() ? a : b;
        String shortS = longS == a ? b : a;
        int bit = 0;
        int i = 0;
        for (; i < shortS.length(); i++) {
            int shortI = shortS.charAt(shortS.length() - 1 - i) - '0';
            int longI = longS.charAt(longS.length() - 1 - i) - '0';
            int tmp = shortI + longI + bit;
            if (tmp == 0) {
                res = '0' + res;
                bit = 0;
            } else if (tmp == 1) {
                res = '1' + res;
                bit = 0;
            } else if (tmp == 2) {
                res = '0' + res;
                bit = 1;
            } else {
                res = '1' + res;
                bit = 1;
            }
            System.out.println(res);
        }
        for (; i < longS.length(); i++) {
            int sub = longS.charAt(longS.length() - 1 - i) - '0';
            int tmp = bit + sub;
            if (tmp == 0) {
                res = '0' + res;
                bit = 0;
            } else if (tmp == 1) {
                res = '1' + res;
                bit = 0;
            } else {
                res = '0' + res;
                bit = 1;
            }
        }
        if (bit == 1)
            res = '1' + res;
        return res;
    }
}
