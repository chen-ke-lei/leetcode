package oj.top100;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sub=max;
        for(int i=1;i<nums.length;i++){
            if(sub<0)
                sub=0;
            sub+=nums[i];
            max=max>sub?max:sub;
        }
        return max;
    }
}
