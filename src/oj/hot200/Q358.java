package oj.hot200;

import java.util.PriorityQueue;

public class Q358 {
    public String rearrangeString(String s, int k) {
        if(k==0)return s;
        int[] tmp = new int[26];
        for (char c : s.toCharArray())
            tmp[c - 'a']++;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]),
                tmpQue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > 0) {
                queue.offer(new int[]{i, tmp[i]});
            }
        }
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (queue.isEmpty()) return "";
            int[] poll = queue.poll();
            buffer.append((char) (poll[0] + 'a'));
            poll[1]--;
            if (poll[1] > 0) tmpQue.offer(poll);
            i++;
            if (i == k) {
                while (!tmpQue.isEmpty())
                    queue.offer(tmpQue.poll());
                i = 0;
            }
        }
        return buffer.toString();
    }


}

