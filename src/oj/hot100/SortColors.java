package oj.hot100;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int left = 0, right = nums.length - 1, mid = 0;
        while (mid < right) {
       //     System.out.println(Arrays.toString(nums) + " " + left + " " + mid + "  " + right);
            if (nums[left] == 0) left++;
            else if (nums[right] == 2) right--;
            else if (nums[left] == 2) {
                nums[left] = nums[right];
                nums[right] = 2;
                right--;
            } else if (nums[right] == 0) {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
            }
            else if (nums[left] == 1) {
                mid++;
                nums[left] = nums[mid];
                nums[mid] = 1;
            } else if (nums[right] == 1) {
                mid++;
                nums[right] = nums[mid];
                nums[mid] = 1;
            }

            if (mid < left) mid = left;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
