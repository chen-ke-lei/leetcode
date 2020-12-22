package oj.top100.review01;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            if (nums[0] != target) return res;
            if (nums[0] == target) return new int[2];
        }
        int left = 0, right = nums.length - 1;
        if (nums[left] > target || nums[right] < target) return res;
        if (nums[0] == target) {
            res[0] = 0;
            while (nums[right] > target) right--;
            res[1] = right;
            return res;
        } else if (nums[right] == target) {
            res[1] = right;
            while (nums[left] < target) left++;
            res[0] = left;
            return res;
        } else {
            while (left < right) {
                int tmp = (left + right) / 2;
                if (nums[tmp] < target) {
                    left = tmp + 1;
                } else if (nums[tmp] > target) {
                    right = tmp;
                } else {
                    left = tmp;
                    right = tmp;
                    while (right < nums.length && nums[right] == target) right++;
                    while (left >= 0 && nums[left] == target) left--;
                    res[0] = left + 1;
                    res[1] = right - 1;
                    return res;
                }
            }
        }
        return res;
    }
}
