package oj;

public class MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int max = A[0];
		int size = 1;
		int tmpMax = max;
		if (tmpMax <= 0) {
			tmpMax = 0;
			size = 0;
		}
		for (int i = 1; i < A.length * 2; i++) {
			int num = A[i % A.length];
			if (num <= 0) {
				if (tmpMax == 0 && size == 0) {
					max = max > num ? max : num;
				} else {
					max = max > tmpMax ? max : tmpMax;
				}

			}
			if (size < A.length) {
				tmpMax += num;
				size++;
				if (tmpMax < 0) {
					tmpMax = 0;
					size = 0;
				}
			} else {
				int tmpVal = tmpMax;
				while (num < 0 && i < A.length * 2 - 1) {
					tmpVal -= num;
					i++;
					num = A[i % A.length];
				}
				max = max > tmpVal ? max : tmpVal;
			}
		}
		if (size > 0)
			max = max > tmpMax ? max : tmpMax;
		return max;
	}

	public static void main(String[] args) {
	}
}
