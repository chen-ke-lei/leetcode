package oj.cap210;

import java.util.*;

public class Q5536 {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<String> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<roads.length;i++){
            set.add(roads[i][0]+","+roads[i][1]);
            map.put(roads[i][0],map.getOrDefault(roads[i][0],0)+1);
            map.put(roads[i][1],map.getOrDefault(roads[i][1],0)+1);
        }
        List<Integer> tmp=new ArrayList<>();
        for(Integer i:map.keySet()){
            for(Integer j:map.keySet()){
                if(i!=j){
                    int num=map.get(i)+map.get(j);
                    if(set.contains(i+","+j)||set.contains(j+","+i))
                        num--;
                    tmp.add(num);
                }
            }
        }
        int max=0;
        for(int i:tmp)
            max=max>i?max:i;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q5536().maximalNetworkRank(4,new int[][]{{0,1},{0,3},{1,2},{1,3}}));
    }
}
