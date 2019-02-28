package oj;

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
		if (A == null || A.length == 0)
			return A;
		int begin = 0, end = A.length - 1;
		while (begin < end) {
			if (A[begin] % 2 == 0) {
				begin++;
			} else if (A[end] % 2 == 1) {
				end--;
			} else {
				int tmp = A[begin];
				A[begin] = A[end];
				A[end] = tmp;
				begin++;
				end--;
			}
		}
		return A;
	}
}
