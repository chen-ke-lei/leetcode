package oj.hot200;

import oj.dto.ArrayReader;

public class Q702 {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        while (reader.get(left) <= target) {
            if (reader.get(left) == target) return left;
            left = (left + 1) * 2;
        }
        int right = left;
        left = left / 2 - 1;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (reader.get(tmp) == target) return tmp;
            else if (reader.get(tmp) < target) left = tmp + 1;
            else right = tmp;
        }
        return -1;
    }
}
