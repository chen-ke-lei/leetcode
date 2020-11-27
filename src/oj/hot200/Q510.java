package oj.hot200;

import oj.dto.hot200.Node;

public class Q510 {
    public Node inorderSuccessor(Node node) {

        if (node.right != null) {
            Node tmp = node.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        }
        if (node.parent != null) {
            Node tmp = node, parent = node.parent;
            while (parent != null && parent.left != tmp) {
                tmp = parent;
                parent = parent.parent;
            }
            return parent;
        }
        return null;
    }
}
