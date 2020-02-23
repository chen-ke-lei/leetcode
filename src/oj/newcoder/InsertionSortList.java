package oj.newcoder;

import oj.dto.DtoUtil;
import oj.dto.ListNode;

// TODO: 2020/2/1  
public class InsertionSortList {
    public static void main(String[] av) {
        ListNode node = DtoUtil.creatListByArray(new int[]{3,4, 2, 1});
        DtoUtil.displayListNode(new InsertionSortList().insertionSortList(node));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode pre = tmpHead, next = head;
        while (next != null && next.next != null) {
            while (pre != next && pre.next.val <= next.next.val) {
                pre = pre.next;
            }
            if (pre != next)
                transfer(pre, next);
            else
                next = next.next;
            DtoUtil.displayListNode(tmpHead.next);
            pre = tmpHead;
        }
        return tmpHead.next;
    }

    //½»»»pre ºÍ pre1 µÄnext
    void transfer(ListNode pre, ListNode pre1) {

        ListNode tmp = pre.next;
        ListNode tmp1 = pre1.next;

        pre1.next = pre1.next.next;
        pre.next = tmp1;
        tmp1.next = tmp;


    }
}
