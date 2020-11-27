package oj.hot200;

import oj.dto.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class Q364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList.isEmpty()) return 0;
        List<Integer> tmp = new ArrayList<>();
        List<NestedInteger> pre = nestedList, next = new ArrayList<>();
        while (!pre.isEmpty()) {
            int sub = 0;
            for (NestedInteger nestedInteger : pre) {
                if (nestedInteger.isInteger()) sub += nestedInteger.getInteger();
                else next.addAll(nestedInteger.getList());
            }
            tmp.add(sub);
            pre = next;
            next = new ArrayList<>();
        }
        int res = 0;
        for (int i = 0; i < tmp.size(); i++) {
            res += (tmp.get(i) * (tmp.size() - i));
        }
        return res;
    }
}
