package oj.hot200;

import oj.dto.NestedInteger;

import java.util.List;

public class Q339 {
    int depth = 1;

    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) res += (nestedInteger.getInteger() * depth);
            else {
                depth++;
                res += depthSum(nestedInteger.getList());
                depth--;
            }
        }

        return res;
    }
}
