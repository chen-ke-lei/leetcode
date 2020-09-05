package oj.swordtooffer.needthinking;

public class Problem53I {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int left = 0, right = nums.length - 1, tmp = 0;
        while (left <= right) {
            tmp = (left + right) / 2;
            if (tmp == left)
                tmp++;
            if (nums[tmp] == target || target > left)
                break;
            if (nums[tmp] > target)
                right = tmp;
            else
                left = tmp;
        }
        if (nums[tmp] == target) {
            left = tmp;
            while (left >= 0 && nums[left] == target)
                left--;
            right = tmp;
            while (right < nums.length && nums[right] == target)
                right++;
            return right - left - 1;
        }
        return 0;
    }
}
