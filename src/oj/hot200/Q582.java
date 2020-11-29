package oj.hot200;

import java.util.*;

public class Q582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!listMap.containsKey(ppid.get(i))) listMap.put(ppid.get(i), new ArrayList<>());
            listMap.get(ppid.get(i)).add(pid.get(i));
        }
        Deque<Integer> deque = new LinkedList<>();
        res.add(kill);
        deque.add(kill);
        while (!deque.isEmpty()) {
            if (listMap.containsKey(deque.getFirst())) {
                deque.addAll(listMap.get(deque.getFirst()));
                res.addAll(listMap.get(deque.getFirst()));
            }
            deque.removeFirst();

        }
        return res;
    }
}
