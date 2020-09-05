package oj.swordtooffer;

public class Problem14I {
    public static void main(String[] a) {
        Problem14I problem14I = new Problem14I();
        System.out.println(problem14I.cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n <= 3)
            return n - 1;
        int[] tmp = new int[n + 1];
        tmp[1] = 0;
        tmp[2] = 2;
        tmp[3] = 3;
        int res;
        for (int i = 4; i <= n; i++) {
            res = i - 1;
            for (int j = 2; j <= i / 2; j++) {
                int a = tmp[j] * tmp[i - j];
                res = a > res ? a : res;
            }
            tmp[i] = res;
            System.out.println(i+"    "+res);
        }
        return tmp[n];
    }


}
