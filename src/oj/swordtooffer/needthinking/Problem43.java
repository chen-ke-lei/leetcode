package oj.swordtooffer.needthinking;

public class Problem43 {
    public static void main(String[] av) {
        System.out.println(new Problem43().countDigitOne(1410065408));
    }

    public int countDigitOne(int n) {
        if (n == 0)
            return 0;
        if (n < 9)
            return 1;
        int res = 0;
        long length = 0, tmp = 1;
        while (tmp <= n) {
            tmp *= 10;
            length++;
        }

        int[] sub = new int[(int) length];
        sub[0] = 1;
        int a = 10;
        for (int i = 1; i < length; i++) {
            sub[i] = 10 * sub[i - 1] + a;
            a *= 10;
        }
       // System.out.println(Arrays.toString(sub));
        tmp /= 10;
        if (n == tmp)
            return sub[(int) length - 2] + 1;

        while (n > 9) {
            int x = (int)( n / tmp);
             if (x == 1) {
                res += ((n - tmp + 1) + sub[(int)(length - 2)]);
            } else if(x>1){
                res += (tmp + x * (sub[(int) (length - 2)]));
            }

            n %= tmp;
            tmp /= 10;
            length--;
        }
        return n > 0 ? res + 1 : res;
    }
}
