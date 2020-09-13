package oj;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(k,n,1,res,new ArrayList<>());
        return res;
    }
    void  dfs(int k,int n,int i , List<List<Integer>> res,List<Integer> tmp){
        if(i>n||i>9||n<0)
            return;
        for(;i<=9;i++){
            if(k==1){
                if(i==n){
                    List<Integer> sub=new ArrayList<>(tmp);
                    sub.add(i);
                    res.add(sub);
                }else if(i>n)
                    return;
            }else {
                tmp.add(i);
                dfs(k-1,n-i,i+1,res,tmp);
                tmp.remove(tmp.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        System.out.print(new CombinationSumIII().combinationSum3(3,7));
    }
}
