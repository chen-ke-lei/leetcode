package oj.top100;

import java.util.*;
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer,Integer>[] sub=new Map[nums.length];
        for(int i=0;i<sub.length;i++)
            sub[i]=new HashMap<>();
        sub[0].put(nums[0],1);
        sub[0].put(-nums[0],1);
        for(int i=1;i<nums.length;i++){
            Map<Integer,Integer> pre=sub[i-1];
            Map<Integer,Integer> now=sub[i];
            for(Integer num:pre.keySet()){
                if(!now.containsKey(num+nums[i]))
                    now.put(num+nums[i],0);
                if(!now.containsKey(num-nums[i]))
                    now.put(num-nums[i],0);
                now.put(num+nums[i],now.get(num+nums[i])+pre.get(num));
                now.put(num-nums[i],now.get(num-nums[i])+pre.get(num));
            }

        }
        return sub[sub.length-1].get(S);
    }
}
