package oj.hot100;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[1];
        int res = 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int index = -1, min = -1, a = 1, b = 1, c = 1;
            for (int j = 1; j < nums.length - 1; j++) {

            }
        }
        return res;
    }
}
