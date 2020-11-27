package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q281 {
    class ZigzagIterator {
        List<Integer> list = new ArrayList<>();
        int index;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            int i = 0;
            list.clear();
            while (i < v1.size() || i < v2.size()) {
                if (i < v1.size()) list.add(v1.get(i));
                if (i < v2.size()) list.add(v2.get(i));
                i++;
            }
            index = 0;
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }
}
