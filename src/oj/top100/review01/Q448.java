package oj.top100.review01;

import java.util.ArrayList;
import java.util.List;

public class Q448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            int sub = nums[i];
            while (sub != i + 1) {
                if (nums[sub - 1] == sub) break;
                int tmp = nums[sub - 1];
                nums[sub - 1] = sub;
                sub = tmp;

            }
            nums[i] = sub;
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                res.add(i + 1);
        return res;
    }
}
