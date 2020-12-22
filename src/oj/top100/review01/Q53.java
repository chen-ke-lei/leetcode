package oj.top100.review01;

public class Q53 {
    public int maxSubArray(int[] nums) {
        return sub(nums, 0, nums.length - 1)[1];
    }

    int[] sub(int[] nums, int i, int j) {
        if (i == j) return new int[]{nums[i], nums[i], nums[i], nums[i]};
        int[] left = sub(nums, i, (i + j) / 2);
        int[] right = sub(nums, (i + j) / 2 + 1, j);
        int res[] = new int[4];
        res[3] = left[3] + right[3];
        res[0] = Math.max(left[0], right[0] + left[3]);
        res[2] = Math.max(right[2], left[2] + right[3]);
        res[1] = Math.max(Math.max(Math.max(res[0], res[2]), Math.max(left[1], right[1])), left[2] + right[0]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
