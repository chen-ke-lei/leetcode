package oj.newcoder;

import oj.dto.RandomListNode;

public class CopyListWithRandomPointer {
    public static void main(String[] av) {
        RandomListNode test = new RandomListNode(-1);
        CopyListWithRandomPointer pointer = new CopyListWithRandomPointer();
        pointer.copyRandomList(test);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode r = head;
        while (r != null) {
            RandomListNode tmp = new RandomListNode(r.label);
            tmp.next = r.next;
            r.next = tmp;
            r = tmp.next;
        }
        r = head;
        while (r != null) {
            if (r.random != null)
                r.next.random = r.random.next;
            r = r.next.next;
        }
        RandomListNode rs = head.next;
        r = rs;
        while ( r.next != null) {
            r.next = r.next.next;
            r = r.next;
        }
        return rs;
    }
}
