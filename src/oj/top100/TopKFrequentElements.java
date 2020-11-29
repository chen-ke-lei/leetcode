package oj.top100;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer,Integer> times=new HashMap<>();
        for(int num:nums){
            if(!times.containsKey(num))
                times.put(num,1);
            times.put(num,times.get(num)+1);
        }
        Map<Integer, List<Integer>> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(Integer i:times.keySet()){
            int time=times.get(i);
            if(!map.containsKey(time)){
                list.add(time);
                map.put(time,new ArrayList<>());
            }
            map.get(time).add(i);
        }
        Collections.sort(list);
        int i=list.size()-1,point=0;
        while (k>0){
            List<Integer> tmp=map.get(list.get(i));
            for(int j=0;j<tmp.size()&&k>0;j++,k--,point++){
                res[point]=tmp.get(j);
            }
            i--;
        }
        return res;
    }
}
