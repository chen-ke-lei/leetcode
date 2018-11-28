package oj;

public class SubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = 0;
		int startIndex = 0;
		long tmp = 1L;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= k) {
				startIndex = i + 1;
				tmp = 1L;
				continue;
			}
			if (nums[i] * tmp < k) {
				tmp *= nums[i];

			} else {
				while (tmp * nums[i] >= k) {
					tmp /= nums[startIndex++];
				}
				tmp *= nums[i];
			}
			res += (i - startIndex + 1);
		}
		return res;
	}

	public int numSubarrayProductLessThanK_Pre(int[] nums, int k) {
		if (k <= 1)
			return 0;
		int prod = 1, ans = 0, left = 0;
		for (int right = 0; right < nums.length; right++) {
			prod *= nums[right];
			while (prod >= k)
				prod /= nums[left++];
			ans += right - left + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new SubarrayProductLessThanK()
				.numSubarrayProductLessThanK(new int[] { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 }, 19));
	}

	// [10,9,10,4,3,8,3,3,6,2,10,10,9,3]
	// 19

	public int numSubarrayProductLessThanK_low(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			long tmp = 1L;
			for (int j = i; j < nums.length; j++) {
				if (tmp * nums[j] < k) {
					res++;
					tmp *= nums[j];
				} else
					break;
			}
		}
		return res;
	}

}
