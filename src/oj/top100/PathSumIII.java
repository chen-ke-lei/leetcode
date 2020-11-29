package oj.top100;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    int max=0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        List<Integer> tmp=new ArrayList<>();
        dfs(root,sum,tmp);
        return max;
    }
    void dfs(TreeNode node, int sum, List<Integer> tmp){
       if(node==null)
           return;
       List<Integer> res=new ArrayList<>();
       for(int i=0;i<tmp.size();i++){
           if(node.val+tmp.get(i)==sum)
               max++;
           res.add(node.val+tmp.get(i));
       }
       if(node.val==sum)
           max++;
       res.add(node.val);
       dfs(node.left,sum,res);
       dfs(node.right,sum,res);

    }

    public static void main(String[] args) {

    }
}
