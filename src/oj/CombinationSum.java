package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,new ArrayList<>(),target,0,0,candidates);
        return res;
    }

    void dfs(  List<List<Integer>> res,List<Integer> tmp,int target,int sub,int i,int[] candidates){
        for(;i<candidates.length;i++){
            if(sub+candidates[i]==target){
                List<Integer> list=new ArrayList<>(tmp);
                list.add(candidates[i]);
                res.add(list);
                break;
            }else if(sub+candidates[i]>target) {
                break;
            }else {
                tmp.add(candidates[i]);
                dfs(res,tmp,target,sub+candidates[i],i,candidates);
                tmp.remove(tmp.size()-1);

            }
        }
    }
}
