package oj.top100.review01;

public class Q581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) left++;
        int right = nums.length - 1;
        while (right > 0 && nums[right] >= nums[right - 1]) right--;
        if (right == 0 || left == nums.length - 1) return 0;
        int min = nums[left + 1], max = nums[right - 1];
        for (int i = left; i <= right; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i <= left; i++) {
            if (nums[i] > min) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= right; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }

        return right - left + 1;
    }
}
