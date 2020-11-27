package oj.interview_tips;

public class Q05_06 {
    public int convertInteger(int A, int B) {
        int res = 0;
        while (A != 0 || B != 0) {
            if (A == 0 || B == 0) {
                res++;
            } else {
                if ((A & 1) != (B & 1)) res++;
            }
            A >>>= 1;
            B >>>= 1;
        }
        return res;
    }

    static String num2String(int n) {
        String res = "";
        while (n != 0) {
            res = (n & 1) + res;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {

        String str1 = "   " + num2String(+528611498);
        String str2 = num2String(-1619967984);
        int num = 0;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != str2.charAt(i)) num++;
        System.out.println(num);
    }
}
