package oj.top100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1)
            return false;
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        Arrays.sort(nums);
        return dfs(nums, sum, 0, 0, new HashSet<>());

    }

    boolean dfs(int[] nums, int target, int i, int sum, Set<Integer> set) {
        for (; i < nums.length; i++) {
            if (sum + nums[i] == target) return true;
            if (set.contains(sum + nums[i])) continue;
            set.add(sum + nums[i]);
            if (dfs(nums, target, i + 1, sum + nums[i], set)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{14, 9, 8, 4, 3, 2};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
