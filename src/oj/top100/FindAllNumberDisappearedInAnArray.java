package oj.top100;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i+1)
                continue;
            int tmp=nums[i];
            nums[i]=-1;
            while (tmp!=-1){
                if(tmp==nums[tmp-1]){
                    break;
                }
                int sub=nums[tmp-1];
                nums[tmp-1]=tmp;
                tmp=sub;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-1)
                res.add(i+1);
        }
        return res;
    }
}
