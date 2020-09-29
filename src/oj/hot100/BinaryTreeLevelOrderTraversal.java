package oj.hot100;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        List<TreeNode> pre=new ArrayList<>(),now=new ArrayList<>();
        List<Integer> nums=new ArrayList<>();
        pre.add(root);
        nums.add(root.val);
        res.add(nums);
        while (!pre.isEmpty()){
            nums=new ArrayList<>();
            for(TreeNode node:pre){
                if(node.left!=null){
                    nums.add(node.left.val);
                    now.add(node.left);
                }
                if(node.right!=null){
                    nums.add(node.right.val);
                    now.add(node.right);
                }
            }
            if(nums.size()>0)
             res.add(nums);
            pre=now;
            now=new ArrayList<>();
        }
        return res;
    }
}
