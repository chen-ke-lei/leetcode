package oj.hot100;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int end=nums.length-1;
        while (end>k-1){
            int left=1,right=end;
            int tmp=nums[0];
            while (left<right){
                if(nums[right]<tmp){
                    right--;
                }else if(nums[left]>=tmp){
                    left++;
                }else {
                    int sub=nums[left];
                    nums[left]=nums[right];
                    nums[right]=sub;
                    left++;
                    right--;
                }

            }
            if(nums[0]<nums[right]){
                nums[0]=nums[right];
                nums[right]=tmp;
            }


            end=right-1;
        }
        System.out.println(Arrays.toString(nums));
        return nums[k-1];
    }

    public static void main(String[] args) {
        new KthLargestElementInAnArray().findKthLargest(new int[]{2,1},1);
    }
}
