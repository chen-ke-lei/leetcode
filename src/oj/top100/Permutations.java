package oj.top100;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] sign=new boolean[nums.length];
        dfs(res,new ArrayList<>(),nums,sign);
        return res;
    }
    void dfs(List<List<Integer>> res,List<Integer> tmp,int[] nums,boolean[] sign){
        if(tmp.size()==nums.length-1){
            for(int i=0;i<nums.length;i++){
                if(!sign[i]){
                    List<Integer> sub=new ArrayList<>(tmp);
                    sub.add(nums[i]);
                    res.add(sub);
                    return;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(!sign[i]){
                sign[i]=true;
                tmp.add(nums[i]);
                dfs(res,tmp,nums,sign);
                tmp.remove(tmp.size()-1);
                sign[i]=false;
            }
        }
    }
}
