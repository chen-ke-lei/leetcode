package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        int tmp = lower - 1;
        for (int num : nums) {

            if (num - tmp == 2) res.add((tmp + 1) + "");
            else if (num - tmp > 2) res.add((tmp + 1) + "->" + (num - 1));

            tmp = num;
        }
        if (upper - tmp > 1) {
            res.add((tmp + 1) + "->" + upper);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q163().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }
}
