package oj.tree;

import oj.dto.TreeNode;

public class ThreadTree {


    public ThreadTreeNode creatPtrByTree(TreeNode node) {
        if (node == null)
            return null;
        ThreadTreeNode ptr = tree2ThreadTree(node);
        threadThreeDfs(ptr, null);
        System.out.print(1);
        return ptr;
    }

    public void threadThreeDfs(ThreadTreeNode node, ThreadTreeNode pre) {
        if (node.left != null) {
            threadThreeDfs(node.left, pre);
        }
        if (node.left == null&&pre!=null) {
            node.left = pre;
            node.ltag = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rTag = 1;
        }
     //   System.out.println((pre==null?"  ":pre.value+"")+"   "+node.value);
        if(pre!=null){

        }
        if(pre!=null&&pre.value==1)
            System.out.println(pre.right);
        pre = node;



        if (node.right != null) {
            threadThreeDfs(node.right, pre);
        }
    }

    ThreadTreeNode tree2ThreadTree(TreeNode node) {
        if (node == null)
            return null;
        ThreadTreeNode ptr = new ThreadTreeNode();
        dfs(node, ptr);
        return ptr;
    }

    void dfs(TreeNode treeNode, ThreadTreeNode threadTreeNode) {
        if (treeNode.left != null) {
            ThreadTreeNode left = new ThreadTreeNode();
            threadTreeNode.left = left;
            dfs(treeNode.left, left);
        }
        threadTreeNode.value = treeNode.val;

        if (treeNode.right != null) {
            ThreadTreeNode right = new ThreadTreeNode();
            threadTreeNode.right = right;
            dfs(treeNode.right, right);
        }
    }

    public static void main(String[] vav) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
      //  System.out.print(new ThreadTree().creatPtrByTree(root));


    }
}
