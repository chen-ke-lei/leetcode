package oj.swordtooffer.needthinking;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem32III {
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
            for (int i = pre.size() - 1; i >= 0; i--) {
                tmp.add(pre.get(i).val);
                if (pre.get(i).right != null)
                    next.add(pre.get(i).right);
                if (pre.get(i).left != null)
                    next.add(pre.get(i).left);
            }
            res.add(tmp);
            pre = next;

        }
        return res;
    }
}
