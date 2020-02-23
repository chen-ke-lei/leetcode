package oj.newcoder;

import java.util.ArrayList;

public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows <= 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        for (int i = 2; i <= 5; i++) {
            tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < res.get(res.size() - 1).size(); j++) {
                tmp.add(res.get(res.size() - 1).get(j) + res.get(res.size() - 1).get(j - 1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
