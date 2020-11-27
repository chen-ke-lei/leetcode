package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q254 {
    public List<List<Integer>> getFactors(int n) {
        if (n <= 2) return new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        while (true) {
            int sub = -1;
            for (int i = 2; i < n; i++) {
                if (n % 2 == 0) {
                    sub = i;
                    break;
                }
            }
            if (sub == -1) break;
            tmp.add(sub);
            n /= sub;
        }
        if (tmp.isEmpty()) return new ArrayList<>();
        if (n > 1)
            tmp.add(n);
        List<List<Integer>> res = new ArrayList<>();
        dfs(tmp, res, new ArrayList<>(), 0, 1, new boolean[tmp.size()]);
        return res;
    }

    void dfs(List<Integer> number, List<List<Integer>> res, List<Integer> tmp, int i, int pro, boolean[] vis) {
        if (i == number.size()) {
            if (pro == 1) {
                res.add(new ArrayList<>(tmp));
            } else {
                if (!tmp.isEmpty()) {
                    res.add(new ArrayList<>(tmp));
                    res.get(res.size() - 1).add(pro);
                }
            }
            return;
        }
        int last = -1;
        for (int j = 0; j < number.size(); j++) {
            if (vis[j]) continue;
            if (number.get(j) == last) continue;
            vis[j] = true;
            last = number.get(j);

                tmp.add(number.get(j)*pro);
                dfs(number, res, tmp, i + 1, 1, vis);
                tmp.remove(tmp.size() - 1);
                dfs(number, res, tmp, i + 1, number.get(j)*pro, vis);


            vis[j] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q254().getFactors(12));
    }
}
