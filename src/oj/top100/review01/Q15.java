package oj.top100.review01;

import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) return new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        int lastI = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (lastI == nums[i]) continue;
            if (nums[i] > 0) break;
            lastI = nums[i];
            int j = i + 1, k = nums.length - 1, target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(res);
    }

}
