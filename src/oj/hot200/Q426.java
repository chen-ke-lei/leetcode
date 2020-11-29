package oj.hot200;


public class Q426 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        return null;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
