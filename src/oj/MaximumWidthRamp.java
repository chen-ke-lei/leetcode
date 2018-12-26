package oj;

public class MaximumWidthRamp {
	public int maxWidthRamp(int[] A) {
		if (A == null || A.length < 2)
			return 0;
		int max = 0;
		int tmpMax = 0;
		int min = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < min) {
				max = Math.max(tmpMax, max);
				min = A[i];
			} else if (A[i] > min) {
				tmpMax = Math.max(tmpMax, A[i] - min);
			}
		}
		max = Math.max(tmpMax, max);
		return max;
	}

}
