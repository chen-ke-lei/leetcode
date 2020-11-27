package oj.hot200;

import oj.dto.hot200.ImmutableListNode;

public class Q1265 {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        if (head.getNext() != null) printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
