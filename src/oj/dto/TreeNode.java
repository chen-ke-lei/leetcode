package oj.dto;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode creatTreeByString(String str) {
        str = str.substring(1, str.length() - 1);
        String[] sub = str.split(",");
        if (sub.length == 0)
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(sub[0]));
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(root);
        int i = 1, index = 0, left = 0;
        while (i < sub.length) {
            if ("null".equals(sub[i])) {
                if (left == 1) {
                    left = 0;
                    index++;
                } else {
                    left = 1;
                }

            } else {
                TreeNode node = new TreeNode(Integer.valueOf(sub[i]));
                next.add(node);

                if (left == 0) {
                    pre.get(index).left = node;
                    left = 1;
                } else {
                    pre.get(index).right = node;
                    left = 0;
                    index++;
                }
            }
            if (index == pre.size()) {
                pre = next;
                next = new ArrayList<>();
                index = 0;
            }
            i++;
        }

        return root;
    }

    public String toString() {
        return this.val + "  left:" + (this.left == null ? null : this.left.val) + "  right:"
                + (this.right == null ? null : this.right.val);
    }
}
