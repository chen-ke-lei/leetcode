package oj;

public class SortArrayByParityII {
	public int[] sortArrayByParityII(int[] A) {
		if (A == null || A.length <= 1)
			return A;
		int[] B = new int[A.length];
		int leftStart = 0;
		int rightStart = 1;
		for (int i : A) {
			if (i % 2 == 0) {
				B[leftStart] = i;
				leftStart += 2;
			} else {
				B[rightStart] = i;
				rightStart += 2;
			}
		}
		return B;
	}
}
