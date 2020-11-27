package oj.hot200;

import java.util.Deque;
import java.util.LinkedList;

public class Q346 {
    class MovingAverage {
        Deque<Integer> integerDeque = new LinkedList<>();
        int length;
        int total;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            length = size;
        }

        public double next(int val) {
            if(integerDeque.size()==length){
                total -= integerDeque.removeFirst();

            }
            integerDeque.addLast(val);
            total += val;
            return total / (integerDeque.size() * (1.0));
        }
    }
}
