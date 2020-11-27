package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q1243 {
    public List<Integer> transformArray(int[] arr) {
        List<Integer> res = new ArrayList<>(), tmp = new ArrayList<>();
        for (int i : arr) {
            res.add(i);
        }
        if (arr.length <= 2) return res;
        boolean end = true;
        while (end) {
            end = false;
            tmp.add(res.get(0));
            for (int i = 1; i < res.size() - 1; i++) {
                if (res.get(i) < res.get(i - 1) && res.get(i) < res.get(i + 1)) {
                    tmp.add(res.get(i) + 1);
                    end = true;
                } else if (res.get(i) > res.get(i - 1) && res.get(i) > res.get(i + 1)) {
                    tmp.add(res.get(i) - 1);
                    end = true;
                } else {
                    tmp.add(res.get(i));
                }
            }
            tmp.add(res.get(res.size() - 1));
            res = tmp;
            tmp = new ArrayList<>();
        }

        return res;
    }

}
