package oj.hot100;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pathP=new ArrayList<>();
            findPath(root,p,pathP);
            List<TreeNode> pathQ=new ArrayList<>();
            findPath(root,q,pathQ);
            for(int i=0;i<pathP.size()&&i<pathQ.size();i++){
                if(pathP.get(i)!=pathQ.get(i))
                    return pathP.get(i-1);
            }
            return pathP.size()>pathQ.size()?pathP.get(pathQ.size()-1):pathQ.get(pathP.size()-1);
        }

        boolean findPath(TreeNode root, TreeNode node, List<TreeNode> paths) {
            if (root == null)
                return false;
            if (node == root) {
                paths.add(root);
                return true;
            }
            paths.add(root);
            if(findPath(root.left,node,paths)) return true;
            if(findPath(root.right,node,paths))return true;
            paths.remove(paths.size()-1);
            return false;
        }
}
