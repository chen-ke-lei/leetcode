package oj.swordtooffer.needthinking;

import oj.dto.ListNode;

public class Problem06 {
    public int[] reversePrint(ListNode head) {
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        int[] res = new int[n];
        dfs(res,head,n);
        return res;
    }

    void dfs(int[] res, ListNode head, int n) {
        if (n>0) {
            dfs(res, head.next, n - 1);
            res[n - 1] = head.val;
        }

    }
}
