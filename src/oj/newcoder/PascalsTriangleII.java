package oj.newcoder;

import java.util.ArrayList;

public class PascalsTriangleII {
    public static void main(String[] av) {
        System.out.println(new PascalsTriangleII().getRow(2));
    }

    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int tmp, restmp;
        for (int i = 1; i <=rowIndex; i++) {
            tmp = 1;
            for (int j = 1; j < i; j++) {
                restmp = tmp + res.get(j);
                tmp = res.get(j);
                res.set(j, restmp);
            }
            res.add(1);
        }

        return res;
    }
}
