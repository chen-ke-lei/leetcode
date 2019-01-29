package oj;

import java.util.Arrays;

public class SmallestRangeII {
	public int smallestRangeII(int[] A, int K) {
		if (A == null || A.length <= 1)
			return 0;
		Arrays.sort(A);
		int[] add = new int[A.length];
		int[] sub = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			add[i] = A[i] + K;
			sub[i] = A[i] - K;
		}
		int base = add[add.length - 1] - add[0];
		int tmpMin = base;
		for (int i = 0; i < A.length - 1; i++) {
			tmpMin = add[i + 1] - sub[i];
		}
		return Math.min(base, tmpMin);
	}

	public static void main(String[] args) {
		System.out.println(new SmallestRangeII().smallestRangeII(new int[] { 3, 1, 10 }, 4));
	}
}
