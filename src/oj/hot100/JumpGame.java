package oj.hot100;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        boolean[] steps = new boolean[nums.length];
        steps[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (steps[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j == nums.length - 1)
                        return true;
                    if (i + j < nums.length)
                        steps[i + j] = true;

                }


            }
        }
        return false;
    }
}
