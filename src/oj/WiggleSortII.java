package oj;

import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		for (int i = 0; i < (nums.length) / 2 * 2 - 2; i += 2) {
			sortBy3(nums, i);
		}
		if (nums.length % 2 == 0) {
			if (nums[nums.length - 2] > nums[nums.length - 1]) {
				int tmp = nums[nums.length - 1];
				nums[nums.length - 1] = nums[nums.length - 2];
				nums[nums.length - 2] = tmp;
			}
		} else {
			sortBy3(nums, nums.length - 3);
		}
	}

	void sortBy3(int[] nums, int i) {
	
		int x1 = nums[i];
		int x2 = nums[i + 1];
		int x3 = nums[i + 2];
		if (x1 > x2) {
			x2 = nums[i];
			x1 = nums[i+1];
		}
		if (x3 <= x1) {
			nums[i] = x3;
			nums[i + 1] = x2;
			nums[i + 2] = x1;
		} else if (x3 >= x2) {
			nums[i] = x1;
			nums[i + 1] = x3;
			nums[i + 2] = x2;
		} else {
			nums[i] = x1;
			nums[i + 1] = x2;
			nums[i + 2] = x3;
		}
	}
	public static void main(String[] args) {
		int[] nums= new int[] {1,2,2,1,2,1,1,1,1,2,2,2};
		WiggleSortII wiggleSortII=new WiggleSortII();
		wiggleSortII.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
