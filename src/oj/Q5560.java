package oj;

import java.util.Deque;
import java.util.LinkedList;

public class Q5560 {
}

class FrontMiddleBackQueue {
    Deque<Integer> frontQueue;
    Deque<Integer> lastQueue;

    public FrontMiddleBackQueue() {
        frontQueue = new LinkedList<>();
        lastQueue = new LinkedList();
    }

    public void pushFront(int val) {
        frontQueue.addFirst(val);
        if (frontQueue.size()  > lastQueue.size())
            lastQueue.addFirst(frontQueue.removeLast());
    }

    public void pushMiddle(int val) {
        if (lastQueue.isEmpty() && frontQueue.isEmpty()) lastQueue.addFirst(val);
        else if (frontQueue.size() < lastQueue.size()) frontQueue.addLast(val);
        else
            lastQueue.addFirst(val);

    }

    public void pushBack(int val) {
        lastQueue.addLast(val);
        if (lastQueue.size() > frontQueue.size() + 1)
            frontQueue.addLast(lastQueue.removeFirst());


    }

    public int popFront() {
        if (lastQueue.isEmpty() && frontQueue.isEmpty()) return -1;
        if (frontQueue.size() > 0) {
            int val = frontQueue.removeFirst();
            if (frontQueue.size() + 1 < lastQueue.size())
                frontQueue.addLast(lastQueue.removeFirst());
            return val;
        }
        return lastQueue.removeFirst();


    }

    public int popMiddle() {
        if (lastQueue.isEmpty() && frontQueue.isEmpty()) return -1;
        if (lastQueue.size() > frontQueue.size()) return lastQueue.removeFirst();
        return frontQueue.removeLast();
    }

    public int popBack() {
        if (lastQueue.isEmpty() && frontQueue.isEmpty()) return -1;
        if (lastQueue.size() > 0) {
            int val = lastQueue.removeLast();
            if (lastQueue.size() < frontQueue.size())
                lastQueue.addFirst(frontQueue.removeLast());
            return val;
        }
        return frontQueue.removeFirst();
    }
}
