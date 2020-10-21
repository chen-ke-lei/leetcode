package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res=new ArrayList<>();
        int[] nums=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
                nums[graph[i][j]]++;
        }
        boolean end=false;
        while (!end){
            end=true;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    nums[i]=-1;
                    for(int j=0;j<graph[i].length;j++){
                        nums[graph[i][j]]--;
                        end=false;
                    }
                }
            }
        }
        for(int i=0;i<nums.length;i++)
            if(nums[i]<=0)
                res.add(i);
        return res;
    }
    //dfs实现 时间复杂度高
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        List<Integer> res=new ArrayList<>();
//        boolean[] booleans=new boolean[graph.length];
//        for(int i=0;i<graph.length;i++)
//           if(!booleans[i])dfs(graph,i,new boolean[graph.length],booleans);
//        for(int i=0;i<booleans.length;i++)
//            if(!booleans[i])
//                res.add(i);
//        return res;
//    }
//
//    void dfs(int[][] graph,int i,boolean[] v,boolean[] booleans ){
//      if(v[i]){
//          booleans[i]=true;
//          return;
//      }
//      v[i]=true;
//      for(int j=0;j<graph[i].length;j++){
//          dfs(graph,graph[i][j],v,booleans);
//          if(booleans[graph[i][j]]) booleans[i]=true;
//      }
//      v[i]=false;
//    }
}
