package oj.interview_tips;

import java.util.ArrayList;
import java.util.List;

public class Q05_04 {
    public int[] findClosedNumbers(int num) {
        int[] res = new int[2];
        List<Integer> list = new ArrayList<>();
        int tmp = num;
        while (tmp > 0) {
            list.add(tmp % 2);
            tmp /= 2;
        }
        int last = -1;
        int i = list.size();
        for (; i >= 0; i--) {
            if (list.get(i) == 1) last = i;
            else if (list.get(i) == 0 && last != 0) {
                list.set(last, 0);
                list.set(i, 1);
                break;
            }
        }
        if (last != -1) {
            for (int j = 0; j < list.size(); j++) {
                res[1] = res[1] * 2 + list.get(j);
            }
        } else {
            if (num * 2 > num)
                res[1] = num * 2;
            else
                res[1] = -1;
            res[0] = -1;
            return res;
        }
        list.set(last, 1);
        list.set(i, 0);
        last = i;
        for (; i >= 0; i--) {
            if (list.get(i) == 1) {
                list.set(last, 1);
                list.set(i, 0);
                break;
            }
        }
        for (int j = 0; j < list.size(); j++) {
            res[0] = res[0] * 2 + list.get(j);
        }
        return res;


    }
}
