package oj.hot200;

import oj.dto.TreeNode;

import java.util.ArrayList;

public class Q431 {
//    class Codec {
//        // Encodes an n-ary tree to a binary tree.
//        public TreeNode encode(Node root) {
//            if (root == null) return null;
//            TreeNode treeNode = new TreeNode(root.val), point = treeNode;
//            if (root.children != null) {
//                for (int i = 0; i < root.children.size(); i++) {
//                    if (i == 0) {
//                        treeNode.left = encode(root.children.get(i));
//                    } else {
//                        point.right = encode(root.children.get(i));
//                        point = point.right;
//                    }
//                }
//            }
//            return treeNode;
//
//        }
//
//        // Decodes your binary tree to an n-ary tree.
//        public Node decode(TreeNode root) {
//            if (root == null) return null;
//            Node node = new Node(root.val);
//            if (root.left == null) return node;
//            node.children = new ArrayList<>();
//            node.children.add(decode(root.left));
//            if (root.right != null) {
//                TreeNode treeNode = root.right;
//                while (treeNode != null) {
//                    node.children.add(decode(treeNode.right));
//                }
//            }
//            return node;
//        }
//    }
}
