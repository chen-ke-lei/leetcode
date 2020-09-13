package oj.hot100;

import oj.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,new ArrayList<>(),nums,0);
        res.add(new ArrayList<>());
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp,int[] nums,int i){
        if(i>=nums.length)
            return;
        for(;i<nums.length;i++){
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            dfs(res,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
