package oj.swordtooffer;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<TreeNode> pre = new ArrayList<>(), next;
        List<Integer> tmp;
        pre.add(root);
        while (!pre.isEmpty()) {
            tmp = new ArrayList<>();
            next = new ArrayList<>();
            for (int i = 0; i < pre.size(); i++) {
                tmp.add(pre.get(i).val);
                if (pre.get(i).left != null)
                    next.add(pre.get(i).left);
                if (pre.get(i).right != null)
                    next.add(pre.get(i).right);
            }
            pre = next;
            res.add(tmp);
        }
        return res;
    }
}
