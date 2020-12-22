package oj.top100.review01;

public class Q169 {
    public int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        int time = 1, num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) time++;
            else time--;
            if (time == 0) {
                time = 1;
                num = nums[i];
            }
        }

        return num;

    }
}
