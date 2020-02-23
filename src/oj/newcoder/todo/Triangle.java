package oj.newcoder.todo;

import java.util.ArrayList;

// TODO: 2020/2/3  
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        ArrayList<Integer> pre = triangle.get(triangle.size() - 1), res = new ArrayList<>();
        for (int i = triangle.size() - 2; i >= 0; i--) {
            ArrayList<Integer> tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                int a = tmp.get(j) + pre.get(j);
                int b = tmp.get(j), c = tmp.get(j) + pre.get(j + 1);
                if (j > 0)
                    b += pre.get(j - 1);
                else
                    b = a;
                a = a < b ? a : b;
                a = a < c ? a : c;
                res.add(a);
            }
            pre = res;
            res = new ArrayList<>();
        }
        return pre.get(0);
    }

}
