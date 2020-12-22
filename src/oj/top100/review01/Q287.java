package oj.top100.review01;

public class Q287 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) return nums[0];
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (left < right) {
            int num = 0;
            for (int i : nums) {
                if (i - 1 >= left && i - 1 <= mid)
                    num++;
            }
            if (left + 1 == right) return num > 1 ? left+1 : right+1;
            if (num > mid - left + 1) right = mid;
            else left = mid;
            mid = (left + right) / 2;
        }
        return left+1;
    }

    public static void main(String[] args) {
        System.out.println(new Q287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
