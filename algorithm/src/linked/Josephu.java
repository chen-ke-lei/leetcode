package src.linked;


public class Josephu {
    public static int clcJosephu(int i) {
        DoubleListNode cricle = createList(i);
        int num = 1;
        while (i > 1) {
            if (num <3) {
                cricle = cricle.next;
                num++;
            } else {

                cricle.pre.next = cricle.next;
                cricle.next.pre = cricle.pre;
                System.out.println("delete" + cricle.data);
                cricle = cricle.next;
            //    System.out.println("circle"+cricle.data);
                num = 1;

                i--;
            }

        }
        return cricle.data;
    }

    static DoubleListNode createList(int num) {
        DoubleListNode head = new DoubleListNode(1);
        DoubleListNode point = head;
        for (int i = 2; i <= num; i++) {
            DoubleListNode node = new DoubleListNode(i);
            node.pre = point;
            point.next = node;
            point = node;
        }
        head.pre = point;
        point.next = head;
        return head;
    }

    public static void main(String[] av) {
        System.out.println(clcJosephu(10));
    }
}

class DoubleListNode {
    public int data;
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode(int i) {
        data = i;
    }
}