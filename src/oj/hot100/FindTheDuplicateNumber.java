package oj.hot100;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int tmp = (right + left) / 2;
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - 1 >= left && nums[i] - 1 <= tmp)
                    num++;
            }
            if (num > tmp - left + 1) {
                right = tmp;
            } else
                left = tmp + 1;

        }
        return left + 1;
    }
}
