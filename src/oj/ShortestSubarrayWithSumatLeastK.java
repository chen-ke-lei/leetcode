package oj;
//leetcode 通过率最低的一题
//没有解出来，几个答案都超时
public class ShortestSubarrayWithSumatLeastK {
	public int shortestSubarraylow(int[] A, int K) {
		if (A == null || A.length == 0)
			return -1;
		int res = A.length + 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0)
				continue;
			if (A[i] >= K)
				return 1;
			int tmp = A[i];
			for (int j = i + 1; j < A.length; j++) {
				tmp += A[j];
				if (tmp >= K) {
					int sub = tmp - K;
					int subSum = 0;
					int subTimes = i;
					for (; i < j; i++) {
						subSum += A[i];
						if (subSum <= sub)
							subTimes = i + 1;
					}
					// System.out.println(j + " " + subTimes);
					res = Math.min(res, j - subTimes + 1);
					i = subTimes;
					// System.out.println(i);
					break;
				} else if (tmp <= 0) {
					i = j;
					break;
				}

			}
		}
		return res == A.length + 1 ? -1 : res;
	}

	public int shortestSubarray(int[] A, int K) {
		if (A == null || A.length == 0)
			return -1;
		int res = A.length + 1;
		int[] sum = new int[A.length + 1];
		int beginIndex = 0;
		int tmpMin = Integer.MAX_VALUE;
		int tmpMinIndex = 0;
		for (int i = 0; i < A.length; i++) {
			sum[i + 1] = sum[i] + A[i];
			if (sum[i + 1] <= 0) {
				sum[i + 1] = 0;
				beginIndex = i + 1;
				tmpMin = Integer.MAX_VALUE;
				tmpMinIndex = 0;

			} else if (sum[i + 1] >= K) {
//				while (tmpMin + K <= sum[i + 1]) {
//					beginIndex = tmpMinIndex ;
//					tmpMin = Integer.MAX_VALUE;
//					for (int j = beginIndex+1; j <= i + 1; j++) {
//						sum[j] -= sum[beginIndex];
//						if (sum[j] <= tmpMin) {
//							tmpMin = sum[j];
//							tmpMinIndex = j;
//						}
//					}
//				}
				int minx=-1;
				if(tmpMin+K<=sum[i+1]) {
					for(int j=tmpMinIndex+1;j<i;j++) {
						if(K+sum[j]<=sum[i+1]) {
							minx=j;
						}
					}
				}
				if(minx!=-1) {
					beginIndex=minx;
					res=Math.min(res, i-beginIndex+1);
					
					i=beginIndex-1;
					sum[beginIndex]=0;
					tmpMin=Integer.MAX_VALUE;
				}else {
					res=Math.min(res, i-beginIndex+1);
				}
				
			} else {
				if (sum[i + 1] <= tmpMin) {
					tmpMin = sum[i + 1];
					tmpMinIndex = i + 1;
				}
			}

		}

		return res == A.length + 1 ? -1 : res;
	}

	public static void main(String[] args) {
		System.out.println(new ShortestSubarrayWithSumatLeastK().shortestSubarray(
				new int[] { 39353, 64606, -23508, 5678, -17612, 40217, 15351, -12613, -37037, 64183, 68965, -19778,
						-41764, -21512, 17700, -23100, 77370, 64076, 53385, 30915, 18025, 17577, 10658, 77805, 56466,
						-2947, 29423, 50001, 31803, 9888, 71251, -6466, 77254, -30515, 2903, 76974, -49661, -10089,
						66626, -7065, -46652, 84755, -37843, -5067, 67963, 92475, 15340, 15212, 54320, -5286 },
				207007));
		// System.out
		// .println(new ShortestSubarrayWithSumatLeastK().shortestSubarray(new int[] {
		// 56, -21, 56, 35, -9 }, 61));
		System.out.println(77370 + 64076 + 53385 + 30915 + 18025);
	}

	public int shortestSubarray2(int[] A, int K) {
		if (A == null || A.length == 0)
			return -1;
		int res = A.length + 1;
		int startIndex = 0;
		int tmpAmount = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= K)
				return 1;
			tmpAmount += A[i];
			if (tmpAmount <= 0) {
				startIndex = i + 1;
				tmpAmount = 0;
			} else if (tmpAmount >= K) {
				int subAmount = tmpAmount - K;
				int tmpRes = A[startIndex];
				int subRes = 0;
				int tmpStartIndex = startIndex;
				for (int j = startIndex; j < i; j++) {
					subRes += A[j];
					if (subRes <= subAmount) {
						tmpStartIndex = j + 1;
						if (subRes <= 0) {
							subAmount -= subRes;
							tmpAmount -= subRes;
							tmpRes = 0;
							subRes = 0;
							while (tmpAmount - A[i] > K) {
								tmpAmount -= A[i];
								subAmount -= A[i];
								i--;
							}
						}
						tmpRes = subRes + A[j + 1];
					}
				}
				tmpAmount -= tmpRes;
				startIndex = tmpStartIndex + 1;
				while (A[startIndex] <= 0) {
					tmpAmount -= A[startIndex];
					startIndex++;
				}
				res = Math.min(res, i - tmpStartIndex + 1);
				while (A[startIndex] <= 0) {
					tmpAmount -= A[startIndex];
					startIndex++;
				}
			}
		}
		return res == A.length + 1 ? -1 : res;
	}
}
