package oj.newcoder;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int bit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + bit == 10) {
                digits[i] = 0;
                bit = 1;
            } else {
                digits[i] = digits[i] + bit;
                bit = 0;
            }
        }
        if (bit == 0)
            return digits;
        else {
            int[] res = new int[digits.length + 1];
            res[0]=1;
            for(int i=0;i<digits.length;i++)
                res[i+1]=digits[i];
            return res;
        }
    }
}
