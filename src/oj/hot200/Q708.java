package oj.hot200;


public class Q708 {
    public Node insert(Node head, int insertVal) {
        Node point = head;
        while (point.val < point.next.val) point = point.next;
        Node realHead = point.next;
        if (insertVal < realHead.val || insertVal > point.val) {
            Node node = new Node(insertVal);
            point.next = node;
            node.next = realHead;
            return head;
        }
        point = realHead;
        while (point.next.val < insertVal) point = point.next;
        Node node = new Node(insertVal);
        point.next = node;
        node.next = realHead;
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }


}
