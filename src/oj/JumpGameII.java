package oj;

public class JumpGameII {
	public static void main(String[] args) {
		System.out.println(new JumpGameII().jump(new int[] { 1, 2, 3 }));
	}

	// toolow 逆推法
	public int jump1(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 1; i < res.length; i++) {
			int tmpMin = nums.length;
			for (int j = 0; j < i; j++) {
				if (nums[j] + j >= i) {
					tmpMin = tmpMin < res[j] + 1 ? tmpMin : res[j] + 1;
				}
			}
			res[i] = tmpMin;
		}
		return res[nums.length - 1];
	}

	// 顺推法 awlays toolow
	public int jump(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			int tmpMin = res[i] + 1;
			if (nums[i] + i >= nums.length - 1)
				return res[i] + 1;
			for (int j = 1; j <= nums[i]; j++) {
				if (res[i + j] == 0 || res[i + j] > tmpMin) {
					System.out.println(i + j + "   " + tmpMin);
					res[i + j] = tmpMin;
				}

			}

		}
		return res[nums.length - 1];
	}
}
