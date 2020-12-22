package oj.top100.review01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int i) {
        if (target == 0 && tmp.size() > 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (i >= candidates.length) return;
        if (candidates[i] > target) return;
        int sub = target;
        while (sub >= candidates[i]) {
            tmp.add(candidates[i]);
            sub -= candidates[i];
            dfs(candidates, sub, res, tmp, i + 1);
        }
        while (sub < target) {
            sub += candidates[i];
            tmp.remove(tmp.size() - 1);
        }
        dfs(candidates, target, res, tmp, i + 1);
    }
}
