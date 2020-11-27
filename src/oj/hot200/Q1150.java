package oj.hot200;

public class Q1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int num = 0;
        for (int i : nums) {
            if (i == target) num++;
        }

        return num>(nums.length%2==0?nums.length:nums.length+1)/2;
    }
}
