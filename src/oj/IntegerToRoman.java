package oj;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        while (num >= 1000) {
            res.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            res.append("CM");
            num -= 900;
        } else if (num >= 500) {
            res.append("D");
            num -= 500;
            while (num >= 100) {
                res.append("C");
                num -= 100;
            }
        } else if (num >= 400) {
            res.append("CD");
            num -= 400;
        } else {
            while (num >= 100) {
                res.append("C");
                num -= 100;
            }
        }

        if (num >= 90) {
            res.append("XC");
            num -= 90;
        } else if (num >= 50) {
            res.append("L");
            num -= 50;
            while (num >= 10) {
                res.append("X");
                num -= 10;
            }
        } else if (num >= 40) {
            res.append("XL");
            num -= 40;
        } else {
            while (num >= 10) {
                res.append("X");
                num -= 10;
            }
        }
        System.out.println(num);
        if (num == 9) {
            res.append("IX");
        } else if (num >= 5) {
            res.append("V");
            num -= 5;
            while (num >= 1) {
                res.append("I");
                num -= 1;
            }
        } else if (num == 4) {
            res.append("IV");
        } else {
            while (num >= 1) {
                res.append("I");
                num -= 1;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(61));
    }
}
