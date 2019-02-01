package oj;

import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {
		if (ratings.length <= 1)
			return 1;
		int[] nums = new int[ratings.length];
		nums[0] = 1;
		int minNum = 1;
		int minIndex = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] < ratings[i - 1]) {
				nums[i] = Math.min(nums[i - 1]-1, 1);
			} else if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			} else {
				nums[i] = 1;
			}
			if (minNum > nums[i]) {
				minNum = nums[i];
				minIndex = i;
			}
//			System.out.println(nums[i]);
		}
		while (minNum <= 0) {
			System.out.println("============"+minIndex);
			System.out.println(Arrays.toString(nums));
			minNum = 1;
			nums[minIndex] = 1;
			int start = minIndex;
			for (int i = start - 1; i >= 0; i--) {
				if (ratings[i] < ratings[i + 1]&&nums[i]>=nums[i+1]) {
					nums[i] = nums[i + 1] - 1;
				} else if (ratings[i] == ratings[i + 1] && nums[i] < 1) {
					nums[i] = 1;
				} else if (ratings[i] > ratings[i + 1]) {
					nums[i] = nums[i + 1] + 1;
				}
				if (minNum > nums[i]) {
					minNum = nums[i];
					minIndex = i;
				}
			//	System.out.println(i+"  "+nums[i]);
			}
			for (int i = start + 1; i < ratings.length; i++) {
				if (ratings[i] > ratings[i - 1]) {
					nums[i] = nums[i - 1] + 1;
				} else if (ratings[i] == ratings[i - 1] && nums[i] < 1) {
					nums[i] = 1;
				} else if (ratings[i] < ratings[i - 1] && nums[i]>=nums[i-1]) {
					nums[i] = nums[i - 1] - 1;
				}
				if (minNum > nums[i]) {
					minNum = nums[i];
					minIndex = i;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			
			res += nums[i];
		}

		return res;
	}

	public static void main(String[] args) {
		Candy candy = new Candy();
		int[] xx = new int[] { 58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89 };
		System.out.println(candy.candy(xx));
	}
}
