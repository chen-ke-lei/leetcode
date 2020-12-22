package oj.top100.review01;

public class Q283 {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) fast++;
            else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        for (; slow < nums.length; slow++)
            nums[slow] = 0;
    }
}
