package oj.swordtooffer;

public class Problem03 {
    public int findRepeatNumber(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (booleans[nums[i]])
                return nums[i];
            else
                booleans[nums[i]] = true;
        }
        return 0;
    }
}
