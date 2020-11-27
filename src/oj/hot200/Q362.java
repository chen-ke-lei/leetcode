package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q362 {
    class HitCounter {
        List<int[]> hitBytime;

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            hitBytime = new ArrayList<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            if (hitBytime.isEmpty()) {
                hitBytime.add(new int[]{timestamp, 1});
            } else {
                hitBytime.add(new int[]{timestamp, 1 + hitBytime.get(hitBytime.size() - 1)[1]});
            }
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            if (hitBytime.isEmpty()) return 0;
            if (timestamp - 300 < hitBytime.get(0)[0]) return hitBytime.get(hitBytime.size() - 1)[1];
            int sub = timestamp - 300;
            int left = 0, right = hitBytime.size() - 1;
            while (left < right) {
                if (left + 1 == right)
                    break;
                int tmp = (left + right) / 2;
                if (hitBytime.get(tmp)[0] == sub) {
                    left = tmp;
                    break;
                } else if (hitBytime.get(tmp)[0] < sub) {
                    left = tmp;
                } else
                    right = tmp;
            }
            return hitBytime.get(hitBytime.size() - 1)[1] - hitBytime.get(left)[1];
        }
    }
}
