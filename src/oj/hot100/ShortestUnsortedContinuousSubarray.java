package oj.hot100;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1)
            return 0;
        if (nums.length == 2) return nums[0] <= nums[1] ? 0 : 2;
        int left = 0, right = nums.length - 1;
        for (; left < nums.length-1; left++)
            if (nums[left+1] < nums[left ]) break;
        if (left == nums.length-1) return 0;
        for (; right > 0; right--)
            if (nums[right-1] > nums[right ]) break;
        int min = Math.min(left, right);
        int max = Math.max(left, right);
        left = min;
        right = max;
        min = nums[left];
        max = nums[right];
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        System.out.println(right+"  "+left);
        for (; left > 0; left--)
            if (nums[left - 1] <= min)
                break;
        for (; right < nums.length - 1; right++)
            if (nums[right + 1] >= max)
                break;
            System.out.println(right+"  "+left);
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().
                findUnsortedSubarray(new int[]{1,2,3,4}));
    }
}
