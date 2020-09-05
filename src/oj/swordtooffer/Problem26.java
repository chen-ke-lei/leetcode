package oj.swordtooffer;

import oj.dto.TreeNode;

public class Problem26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        return subStructure(A, B);
    }

    public boolean subStructure(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.val == B.val && subdfs(A, B)) return true;
        if (subStructure(A.left, B)) return true;
        if (subStructure(A.right, B)) return true;
        return false;
    }

    public boolean subdfs(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.val != B.val) return false;
        if (!subdfs(A.left, B.left)) return false;
        if (!subdfs(A.right, B.right)) return false;
        return true;
    }
}
