package oj.hot200;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1086 {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            if (!map.containsKey(id)) map.put(id, new PriorityQueue<>((a, b) -> b - a));
            map.get(id).offer(item[1]);
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            PriorityQueue<Integer> queue = map.get(integer);
            res[i][0] = integer;
            int length = 0;
            int sum = 0;
            while (!queue.isEmpty() && length < 5) {
                sum += queue.poll();
                length++;
            }
            res[i][1] = sum / length;
            i++;
        }
        return res;
    }
}
