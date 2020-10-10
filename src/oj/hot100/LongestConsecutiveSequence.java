package oj.hot100;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int res = 0;
        int hash = nums.length * 2 + 1;
        List<Integer>[] hashArray = new List[hash];
        for (int i : nums) {
            int index = i % hash;
            if (hashArray[index] == null)
                hashArray[index] = new ArrayList<>();
            hashArray[index].add(i);
        }
        int startIndex=-1,tmp=0,startNum,lastNum;
        for(int i=0;i<hashArray.length;i++){
            if(hashArray[i]==null||hashArray[i].isEmpty()){
                if(startIndex!=-1){

                }
            }
        }
        return res;
    }
}
