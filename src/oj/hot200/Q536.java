package oj.hot200;

import oj.dto.TreeNode;

public class Q536 {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        TreeNode node = null;
        if (s.indexOf("(") == -1) {
            node = new TreeNode(Integer.valueOf(s));
        } else {
            node = new TreeNode(Integer.valueOf(s.substring(0, s.indexOf("("))));
            int stack = 0;
            int start = -1;
            boolean bol = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack++;
                    if (start == -1) start = i;
                } else if (s.charAt(i) == ')') stack--;
                if (stack == 0 && start != -1) {
                    if (!bol) {
                        node.left = str2tree(s.substring(start + 1, i));
                    } else {
                        node.right = str2tree(s.substring(start + 1, i));
                    }
                    start = -1;
                    bol = true;
                }
            }
        }

        return node;
    }
}
