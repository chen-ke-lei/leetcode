package oj.hot200;

public class Q487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0)return 0;
        int change = -1, res = 1, start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && start == -1) continue;
            if (nums[i] == 1) {
                if (start == -1) start = i;
                res = res > i - start + 1 ? res : i - start + 1;
            } else {
                if (change == -1) {
                    change = i;
                    res = res > i - start + 1 ? res : i - start + 1;
                } else {
                    start = change+1;
                    change = i;
                    res = res > i - start + 1 ? res : i - start + 1;
                }
            }
        }
        if (start > 0) {
            if (change == -1)
                res = res > nums.length - start + 1 ? res : nums.length - start + 1;
            else
                res = res > nums.length - start ? res : nums.length - start;
        }
        return res;
    }
}
