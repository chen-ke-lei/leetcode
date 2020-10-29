package oj.hot100;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] step = new int[n + 1];
        int i = 1;
        while (i * i <= n) {
            step[i * i] = 1;
            if (i * i == n)
                return 1;
            i++;
        }

        for (i = 2; i <= n; i++) {
            if (step[i] == 1) continue;
            for (int j = 1; j < i; j++) {
                if (step[j] > 0 && step[i - j] > 0) {
                    if (step[i] == 0 || step[i] > step[j] + step[i - j])
                        step[i] = step[j] + step[i - j];
                }
            }
        }
        return step[n];
    }
}
