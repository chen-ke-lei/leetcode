package oj.top100.review01;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, boolean[] vis, int[] nums) {
        if (tmp.size() == vis.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            tmp.add(nums[i]);
            dfs(res, tmp, vis, nums);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
