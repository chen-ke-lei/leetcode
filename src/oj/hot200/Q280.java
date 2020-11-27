package oj.hot200;

import java.util.Arrays;

public class Q280 {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 2) return;
        int last = -1;
        for (int i = 2; i < nums.length; i++) {
            int[] tmp;
            if (last != -1) {
                tmp = new int[4];
            } else tmp = new int[3];
            tmp[0] = nums[i - 2];
            tmp[1] = nums[i - 1];
            tmp[2] = nums[i];
            if (last != -1) tmp[3] = nums[last];
            Arrays.sort(tmp);
            if (last > 0) nums[last] = tmp[3];
            nums[i - 1] = tmp[2];
            nums[i - 2] = tmp[1];
            nums[i] = tmp[0];
            last = i - 1;
        }
    }
}
