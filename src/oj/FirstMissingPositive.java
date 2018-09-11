package oj;


public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] {3,3,2,1}));
	}
	public int firstMissingPositive(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<1||nums[i]>nums.length||i+1==nums[i])
				continue;
			int val=nums[i];
			int tmp=nums[i];
			nums[i]=-1;
			while(true) {
			tmp=nums[val-1];	
			nums[val-1]=val;
			if(tmp==val||tmp<1||tmp>nums.length)
				break;
			val=tmp;
			}
		}
		for(int i=0;i<nums.length;i++)
			if(nums[i]!=i+1)
				return i+1;
		return nums.length+1;
    }

}
