package oj.hot100;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int beg=0,end=nums.length-1,mid=0;
        while (beg+mid<end){
            if(nums[beg]==0){
                beg++;
            }else if(nums[end]==2){
                end--;
            }else if(nums[beg]==1){

                nums[beg]=nums[beg+mid];
                nums[beg+mid]=1;
                mid++;
            }else if(nums[end]==1){

                nums[end]=nums[beg+mid];
                nums[beg+mid]=1;
                mid++;
            }else {
                nums[beg]=0;
                nums[end]=2;
                beg++;
                end--;
            }
            System.out.println(Arrays.toString(nums)+"  "+beg+"  "+end+"  "+mid);
        }
        for(int i=beg;i<=end;i++)
            nums[i]=1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
