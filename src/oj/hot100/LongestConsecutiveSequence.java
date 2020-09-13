package oj.hot100;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res=0;
        int tmp=0;
        int lastNum;
        List<Integer>[] hashArray=new List[nums.length*2];
        for(int i=0;i<hashArray.length;i++)
            hashArray[i]=new ArrayList<>();
        for(int num:nums)
            hashArray[num%hashArray.length].add(num);
        for(List<Integer> numbers:hashArray){
            if(numbers.isEmpty()){
                tmp=0;
                continue;
            }
            if(numbers.size()==1){

            }

        }
        return res;
    }
}
