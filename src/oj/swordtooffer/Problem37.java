package oj.swordtooffer;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem37 {
    public static void main(String[] av) {
        Codec codec = new Codec();
       System.out.print( codec.deserialize("[1,2]"));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        String res = "", tmp = "";
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(root);
        while (!pre.isEmpty()) {
            for (int i = 0; i < pre.size(); i++) {
                if (pre.get(i) == null) {
                    tmp += "null,";
                } else {
                    res += (tmp + pre.get(i).val + ",");
                    tmp = "";
                    next.add(pre.get(i).left);
                    next.add(pre.get(i).right);
                }

            }
            pre = next;
            next = new ArrayList<>();
        }
        return "[" + res.substring(0, res.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] numbers = data.split(",");
        if (numbers.length == 0 || (numbers.length == 1 && numbers[0].length() == 0)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(numbers[0]));
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(root);
        int i = 1;
      //  System.out.println(numbers.length);
        while (!pre.isEmpty() && i < numbers.length) {
            for (int j = 0; j < pre.size(); j++) {
                if (i<numbers.length&&!numbers[i].equals("null")) {
                    TreeNode node = new TreeNode(Integer.valueOf(numbers[i++]));
                    pre.get(j).left = node;
                    next.add(node);
                }
                if (i<numbers.length&&!numbers[i].equals("null")) {
                    TreeNode node = new TreeNode(Integer.valueOf(numbers[i++]));
                    pre.get(j).right = node;
                    next.add(node);
                }
            }
            pre = next;
            next = new ArrayList<>();
        }
        return root;
    }
}