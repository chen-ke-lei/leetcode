package oj.top100.review01;

public class Q33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            return -1;
        }
        int base = 0;
        if (nums[0] > nums[nums.length - 1]) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int tmp = (left + right) / 2;
                if (nums[tmp] > nums[left]) {
                    left = tmp;
                } else if (nums[tmp] < nums[left]) {
                    right = tmp;
                }
                if (left + 1 == right) {
                    base = right;
                    break;
                }
            }
        }
        int left = 0, right = nums.length - 1;
        if (nums[(left + base) % nums.length] == target) return (left + base) % nums.length;
        if (nums[(right + base) % nums.length] == target) return (right + base) % nums.length;
        if (nums[(right + base) % nums.length] < target) return -1;
        if (nums[(left + base) % nums.length] > target) return -1;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (nums[(tmp + base) % nums.length] == target)
                return (tmp + base) % nums.length;
            if (nums[(tmp + base) % nums.length] < target) {
                left = tmp + 1;
            } else {
                right = tmp;
            }
        }

        return -1;
    }
}
