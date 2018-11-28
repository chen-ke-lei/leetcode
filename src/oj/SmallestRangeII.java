package oj;

import java.util.Arrays;

public class SmallestRangeII {
	public int smallestRangeII(int[] A, int K) {
		if (A == null || A.length <= 1)
			return 0;
		int res = Integer.MAX_VALUE;
		Arrays.sort(A);
		int[] maxMin = new int[A.length];
		int[] minMax = new int[A.length];
		maxMin[0] = A[0] + K;
		minMax[A.length - 1] = A[A.length - 1] - K;
		for (int i = 1; i < A.length; i++)
			maxMin[i] = Math.min(maxMin[i - 1], A[i] - K);
		for (int i = A.length - 2; i >= 0; i--)
			minMax[i] = Math.max(A[i] + K, minMax[i + 1]);
		System.out.println(Arrays.toString(minMax));
		System.out.println(Arrays.toString(maxMin));

		for (int i = 1; i < A.length - 2; i++) {
			res = Math.min(res, minMax[i + 1] - maxMin[i]);
			
		}
		if(A[0]+K>maxMin[A.length-1]) {
			res=Math.min(A[0]+K-maxMin[A.length-2], res);
			res = Math.min(res, minMax[1] - minMax[A.length-1]);
		}else {
			res=Math.min(res, minMax[A.length-1]-maxMin[A.length-2]);
			res = Math.min(res, minMax[1] -maxMin[0]);
		}
		
	
		return res;

	}

	public static void main(String[] args) {
		System.out.println(new SmallestRangeII().smallestRangeII(new int[] {7,8,8},5));
	}
}
