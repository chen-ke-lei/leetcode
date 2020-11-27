package oj.interview_tips;

public class Q05_03 {
    public int reverseBits(int num) {
        if (num == 0) return 0;
        int res = 0;
        int start = -1, beg = -1;
        int i = 0;
        boolean change = false;
        while (num > 0) {
            if (num % 2 == 1) {
                if (beg == -1) {
                    beg = 1;
                    start = -1;
                } else if (change && start == -1) {
                    start = i;
                }
                res = res > i - beg + 1 ? res : i - beg + 1;
            } else {
                if (!change) {
                    change = true;
                    res = res > i - beg + 1 ? res : i - beg + 1;
                } else {
                    beg = start;
                    start = -1;

                }
            }
            num /= 2;
            i++;
        }
        return res;
    }
}
