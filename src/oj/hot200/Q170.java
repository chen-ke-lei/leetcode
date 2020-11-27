package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q170 {
    class TwoSum {
        List<Integer> list = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            list.add(number);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            list.sort((x1, x2) -> x1 - x2);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > value / 2) return false;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) + list.get(j) == value) return true;
                    if (list.get(i) + list.get(j) > value) break;
                }
            }
            return false;
        }
    }
}
