package oj.hot100;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        int beg = -1;
        if (nums[left] < nums[right]) {
            beg = 0;
        } else {
            while (true) {
                int tmp = (left + right) / 2;
                if (nums[tmp] > nums[right]) {
                    left = tmp;
                } else {
                    right = tmp;
                }
                if (left + 1 == right) {
                    beg = right;
                    break;
                }
            }
        }
        int end = (beg - 1 + nums.length) % nums.length;
        if (nums[beg] == target) return beg;
        if (nums[end] == target) return end;

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int tmp = (left + right) / 2;
            if (nums[(tmp + beg) % nums.length] == target)
                return (tmp + beg) % nums.length;
            else if (nums[(tmp + beg) % nums.length] < target)
                left = tmp + 1;
            else
                right = tmp;
        }

        return -1;
    }
}
