package oj.tag_graph;

import java.util.*;
public class SortIntegersByThePowerValue {
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer>  steps=new HashMap<>();
        steps.put(1,0);
        for(int i=lo;i<=hi;i++)cal(i,steps);
        int[] index=new int[hi-lo+1];
        Map<Integer,List<Integer>> pows=new HashMap<>();
        for(int i=lo;i<=hi;i++){
            index[i-lo]=steps.get(i);
            if(!pows.containsKey(steps.get(i)))
                pows.put(steps.get(i),new ArrayList<>());
            pows.get(steps.get(i)).add(i);
        }
        Arrays.sort(index);
        int i=0;
        while (i<k){
            List<Integer> list=pows.get(index[i]);
            if(list.size()>0)
                Collections.sort(list);
            if(i+list.size()>=k)
                return list.get(k-i-1);
            i+=list.size();
        }
        return 0;
    }
    int cal(int i,Map<Integer,Integer> steps){
        if(steps.containsKey(i))
            return steps.get(i);
        if(i==1)
            return 0;
        int res;
        if(i%2==0)
            res=cal(i/2,steps);
        else
            res=cal(i*3+1,steps);
        steps.put(i,res+1);
        return res+1;
    }
    public static void main(String[] args) {
        System.out.println(new SortIntegersByThePowerValue().getKth(12,15,2));
    }
}
