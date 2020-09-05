package oj.swordtooffer;

public class Problem21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] % 2 == 1)
                left++;
            else if (nums[right] % 2 == 0)
                right--;
            else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
