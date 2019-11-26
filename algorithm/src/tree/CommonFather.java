package src.tree;

import oj.dto.ListNode;
import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CommonFather {
    public static TreeNode commonfather(TreeNode root, int t1, int t2) {
        List<TreeNode> path1 = new ArrayList<>(), path2 = new ArrayList<>();
        if (getPath(root, path1, t1) && getPath(root, path2, t2)) {
            int i = 0, j = 0;
            while (i < path1.size() && j < path2.size()) {
                if (path1.get(i) == path2.get(j)) {
                    i++;
                    j++;
                } else
                    return path1.get(i - 1);
            }
            return path1.get(i - 1);
        }
        return null;

    }

    //  ÕÒµ½Â·¾¶
    public static boolean getPath(TreeNode node1, List<TreeNode> paths, int val) {
        if (node1 == null)
            return false;
        boolean res = false;
        paths.add(node1);
        if (node1.val == val)
            return true;

        if (getPath(node1.left, paths, val))
            return true;
        if (getPath(node1.right, paths, val))
            return true;
        paths.remove(paths.size() - 1);
        return false;
    }

    public static void main(String[] av) {
        System.out.print(commonfather(TreeUtil.createApproachBalanceTree(15), 1, 5).val);
    }
}
