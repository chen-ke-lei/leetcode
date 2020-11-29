package oj.top100;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int fast = 0, low = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[low] = nums[fast];
                low++;

            }
            fast++;
        }
        for (; low < nums.length; low++) {
            nums[low] = 0;
        }
    }
}
