package oj.hot100;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<=1)
            return 0;
        int left=0;
        outer:
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=nums[i-1])
                left=i;
            else {
              //  System.out.println(i);
                for(int j=0;j<i;j++){
                    if(nums[j]<=nums[i]){
                        left=j;
                    } else{
                       left=j;
                        break outer;
                    }

                }

            }
        }
        int right=nums.length-1;
        outer:
        for(int i=nums.length-2;i>=left;i-- ){
            if(nums[i]<=nums[i+1])
                right=i;
            else {
                for(int j=nums.length-1;j>i;j--){
                    if(nums[i]<=nums[j])
                        right=j;
                    else{
                        right=j;

                        break outer;
                    }

                }
            }
        }
     //   System.out.println(left+"   "+right);
        return right-left+1;
    }

    public static void main(String[] args) {
        new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}
