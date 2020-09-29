package oj.hot100;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int red=0,white=0,blue=nums.length-1;
        while (red+white<=blue){
            if(nums[red]==0){
                red++;
            }else if(nums[red]==1){
                nums[red]=0;
                white++;
            }else if(nums[blue]==2){
                blue--;
            }else if(nums[blue]==1) {
                nums[blue]=2;
                white++;

            }else {
                nums[red]=0;
                nums[blue]=2;
                red++;
                blue--;
            }
        }

        for(int i=0;i<white;i++){
            nums[i+red]=1;
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,0,1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
