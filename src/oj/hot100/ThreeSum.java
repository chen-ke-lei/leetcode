package oj.hot100;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    if (!set.contains(tmp.toString()))
                        res.add(tmp);
                    set.add(tmp.toString());

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
