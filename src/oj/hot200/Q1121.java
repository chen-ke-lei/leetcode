package oj.hot200;

public class Q1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        if (nums.length == 1) return true;
        int dupNum = 1, maxDup = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                dupNum++;
                maxDup = maxDup > dupNum ? maxDup : dupNum;
            } else {
                last = nums[i];
                dupNum = 1;
            }
        }
        return maxDup * K <= nums.length;
    }
}
