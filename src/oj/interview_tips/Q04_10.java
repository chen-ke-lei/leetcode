package oj.interview_tips;

import oj.dto.TreeNode;

public class Q04_10 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (t1.val == t2.val && dfs(t1, t2)) return true;
        if (checkSubTree(t1.left, t2)) return true;
        if (checkSubTree(t1.right, t2)) return true;
        return false;
    }

    boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        if (!dfs(t1.left, t2.left)) return false;
        if (!dfs(t1.right, t2.right)) return false;
        return true;
    }
}
