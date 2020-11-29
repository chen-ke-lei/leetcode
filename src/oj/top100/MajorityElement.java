package oj.top100;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res=nums[0];
        int stack=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==res)
                stack++;
            else {
                stack--;
                if(stack<0){
                    stack=1;
                    res=nums[i];
                }
            }
        }
        return res;
    }
}
