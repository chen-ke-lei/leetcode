package oj.interview_tips;

import java.util.Arrays;

public class Q10_11 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length / 2; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + nums.length / 2 + 1];
            nums[i + nums.length / 2 + 1] = tmp;
        }
    }
}
