package oj.top100.review01;

import java.util.Arrays;

public class Q75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left + mid <= right) {
            //   System.out.println(Arrays.toString(nums) + "  " + left + "  " + right + "  " + mid);
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
            } else if (nums[left] == 1) {
                while (left + mid <= right && nums[left + mid] == 1) mid++;
                if (left + mid >= right) break;
                nums[left] = nums[left + mid];
                nums[left + mid] = 1;
            } else if (nums[right] == 1) {
                //   mid++;
                nums[right] = nums[left];
                nums[left] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2, 0, 0, 0, 1, 1};
        new Q75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
