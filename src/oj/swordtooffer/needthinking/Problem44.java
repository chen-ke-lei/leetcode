package oj.swordtooffer.needthinking;

public class Problem44 {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        int  mul = 10, tmp = n;
        while (tmp > 0) {
            if (tmp - mul >= 0) {
                mul *= 10;
                tmp -= mul;
            }
            tmp += 10;
            while (tmp > 10) {
                mul /= 10;
                tmp %= 10;
            }
            return tmp;

        }
        return 0;
    }
}
