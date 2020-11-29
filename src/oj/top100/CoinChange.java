package oj.top100;

import java.util.HashSet;
import java.util.Set;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount + 1];
        nums[0] = 1;
        Set<Integer> coinSet = new HashSet<>();
        for (int i : coins)
            coinSet.add(i);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > 0)
                    if (coinSet.contains(i - j))
                        if (nums[i] == 0)
                            nums[i] = nums[j] + 1;
                        else
                            nums[i] = Math.min(nums[i], nums[j] + 1);
            }
        }
        return nums[amount] == 0 ? -1 : nums[amount] - 1;
    }
}
