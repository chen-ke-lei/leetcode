package oj;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int end=nums.length-1;
       for(int i=0;i<nums.length-1;i++){
           if(nums[i]!=0)
               continue;
           for(int j=i+1;j<=end;j++){
                int tmp=nums[j-1];
                nums[j-1]=nums[j];
                nums[j]=tmp;

           }
           end--;
       }
    }

    public static void main(String[] args) {
        int[] ints=new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
