package oj.top100.review01;

import oj.dto.TreeNode;

public class Q297 {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            StringBuilder builder = new StringBuilder();
            builder.append("[" + root.val);
            builder.append(serialize(root.left));
            builder.append(serialize(root.right));
            builder.append("]");
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            data = data.substring(1, data.length() - 1);
            if (data.length() == 0) return null;
            int start = data.indexOf("[");
            String numStr = data.substring(0, start);
            TreeNode root = new TreeNode(Integer.valueOf(numStr));
            int stack = 1;
            for (int i = start + 1; i < data.length(); i++) {
                if (data.charAt(i) == '[') stack++;
                else if (data.charAt(i) == ']') stack--;
                if (stack == 0) {
                    root.left = deserialize(data.substring(start, i + 1));
                    root.right = deserialize(data.substring(i + 1));
                    break;
                }
            }
            return root;
        }

        public static void main(String[] args) {
            TreeNode node = TreeNode.creatTreeByString("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]");
            String str = new Codec().serialize(node);
            System.out.println(str);
            new Codec().deserialize(str);
        }
    }
}
