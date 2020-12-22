package oj.top100.review01;

import java.util.Arrays;

public class Q31 {
    public void nextPermutation(int[] nums) {
        boolean find = false;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                find = true;
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = tmp;
                        break;
                    }
                }
                for (int j = i; j < (nums.length  + i) / 2; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[nums.length - 1 - j + i];
                    nums[nums.length - 1 - j + i] = tmp;
                }
                break;
            }

        }
        if (!find) {
            for (int i = 0; i < nums.length / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3,8,7, 6,5,2,};
        new Q31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
