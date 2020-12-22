package oj.top100.review01;

import java.util.Arrays;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        Integer[] tmp = new Integer[26];
        Arrays.fill(tmp, 0);
        for (char task : tasks) {
            tmp[task - 'A']++;
        }
        n++;
        Arrays.sort(tmp, (a, b) -> b - a);
        int res = 0;

        while (n<=26&&tmp[n - 1] > 0) {
            res += n;
            for (int i = 0; i < n; i++) tmp[i]--;
            Arrays.sort(tmp, (a, b) -> b - a);
        }
        if (tmp[0] > 0) {
            int sub = tmp[0] - 1;

            res += n * sub;
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == 0) break;
                tmp[i] = Math.max(0, tmp[i] - sub);
            }
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == 0) break;
                res++;
            }
        }
        return res;
    }
}
