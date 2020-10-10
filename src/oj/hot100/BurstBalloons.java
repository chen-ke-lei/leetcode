package oj.hot100;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[1];
        int res = 0;
        List<Integer> tmp = new ArrayList();
        tmp.add(1);
        for (int i : nums)
            tmp.add(i);
        tmp.add(1);
        for (int i = 1; i < tmp.size() - 1; i++) {
            int min = Integer.MAX_VALUE, index = -1;
            for (int j = 1; j < tmp.size() - 1; j++) {
                if (tmp.get(j) > 0 && tmp.get(j) < min) {
                    min = tmp.get(j);
                    index = j;
                }

            }
            int left = -1;
            for (int j = index - 1; j >= 0; j--) {
                if (tmp.get(j) == -1)
                    continue;
                left = tmp.get(j);
                break;

            }
            int right = -1;
            for (int j = index + 1; j < tmp.size(); j++) {
                if (tmp.get(j) == -1)
                    continue;
                right = tmp.get(j);
                break;

            }
            res += (right * left * tmp.get(index));
            tmp.set(index, -1);
        }
        return res;
    }
}
