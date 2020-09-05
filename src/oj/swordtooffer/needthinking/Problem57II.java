package oj.swordtooffer.needthinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem57II {
    public static void main(String[] av) {
        System.out.println(Arrays.toString(new Problem57II().findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int beg = 1, end = 2;
        int tmp = 3;
        while (beg <= target / 2 && end <= target / 2 + 1 && beg < target) {
            if (tmp > target) {
                tmp -= beg;
                beg++;
            } else if (tmp < target) {
                tmp += ++end;

            } else if (tmp == target) {
                int[] array = new int[end - beg + 1];
                for (int i = 0; i < array.length; i++)
                    array[i] = i + beg;
                res.add(array);
                tmp -= beg;
                beg++;
            }
        }

        int[][] reaA = new int[res.size()][];
        for (int i = 0; i < reaA.length; i++)
            reaA[i] = res.get(i);
        return reaA;
    }
}
