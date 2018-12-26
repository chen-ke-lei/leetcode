package oj;

import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {
	public boolean canReorderDoubled(int[] A) {
		if (A.length == 0)
			return true;
		Map<Integer, Integer> numTimes = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (!numTimes.containsKey(A[i])) {
				numTimes.put(A[i], 0);
			}
			numTimes.put(A[i], numTimes.get(A[i]) + 1);
		}
		for (int i = 0; i < A.length; i++) {
			if (numTimes.containsKey(A[i] * 2) && numTimes.get(A[i] * 2) > 0) {
				numTimes.put(A[i] * 2, numTimes.get(A[i] * 2) - 1);
			}else if(A[i]%2==0 && numTimes.containsKey(A[i]/2)&&  numTimes.get(A[i]/ 2) > 0) {
				numTimes.put(A[i] / 2, numTimes.get(A[i] / 2) - 1);
			}else {
				return false;
			}
		}
		return true;
	}
}
