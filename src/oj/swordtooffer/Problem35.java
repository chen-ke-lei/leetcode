package oj.swordtooffer;


public class Problem35 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node point = head, next;
        while (point != null) {
            next = new Node(point.val);
            next.next = point.next;
            point.next = next;
            point = next.next;
        }
        point = head;
        while (point != null) {
            next = point.next;
            if(point.random!=null)
                next.random = point.random.next;
            point = next.next;
        }
        Node res = head.next;
        point = head.next;
        while (point != null&&point.next!=null) {
            point.next = point.next.next;
            point = point.next;
        }
        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}