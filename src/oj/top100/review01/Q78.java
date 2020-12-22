package oj.top100.review01;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, new ArrayList<>(), 0, nums);
        return lists;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, int i, int[] nums) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        dfs(res, tmp, i + 1, nums);
        tmp.add(nums[i]);
        dfs(res, tmp, i + 1, nums);
        tmp.remove(tmp.size() - 1);
    }
}
