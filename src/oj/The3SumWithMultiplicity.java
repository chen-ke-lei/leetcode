package oj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class The3SumWithMultiplicity {
	public int threeSumMulti(int[] A, int target) {
		long res = 0;
		Map<Integer, Integer> numTimes = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (numTimes.containsKey(A[i])) {
				numTimes.put(A[i], numTimes.get(A[i]) + 1);
			} else { 
				numTimes.put(A[i], 1);
			}
		}
		System.out.println(numTimes);
		if (numTimes.containsKey(target / 3) && numTimes.get(target / 3) >= 3 && target % 3 == 0) {
			int times = numTimes.get(target / 3);
			if (times > 100) {
				BigDecimal tmp = BigDecimal.valueOf(times).multiply(BigDecimal.valueOf(times - 1))
						.multiply(BigDecimal.valueOf(times - 2)).divide(BigDecimal.valueOf(6))
						.divideAndRemainder(BigDecimal.valueOf(1000000007))[1];
				res += tmp.intValue();
			} else {
				res += (times) * (times - 1) * (times - 2) / 6;
			}
			System.out.println(res);
			res %= 1000000007;
		}
		List<Integer> nums = new ArrayList<>(numTimes.keySet());
		Collections.sort(nums);
		for (int i = 0; i < nums.size() - 1 && nums.get(i) <= (target / 2 + 2); i++) {
			int numI = nums.get(i);
			for (int j = i + 1; j < nums.size(); j++) {
				int numJ = nums.get(j);
				if (numI + numJ * 2 >= target || numI * 2 + numJ >= target) {

					if (numTimes.get(numI) >= 2 && numI * 2 + numJ == target) {
						System.out.println(numI + " " + numJ);
						res += (numTimes.get(numJ) * numTimes.get(numI) * (numTimes.get(numI) - 1) / 2);
					}
					res %= 1000000007;
					if (numTimes.get(numJ) >= 2 && numI + numJ * 2 == target) {
						System.out.println(numI + " " + numJ);
						res += (numTimes.get(numI) * numTimes.get(numJ) * (numTimes.get(numJ) - 1) / 2);
					}
					res %= 1000000007;
					if (numI * 2 + numJ >= target)
						break;
					else
						continue;
				}
				for (int k = j + 1; k < nums.size(); k++) {
					int numK = nums.get(k);
					if (numI + numJ + numK >= target) {
						if (numI + numJ + numK == target) {
							res += (numTimes.get(numI) * numTimes.get(numJ) * numTimes.get(numK));
							res %= 1000000007;
						}
						break;
					}
				}
			}
		}
		return (int) (res % 1000000007);
	}

	public static void main(String[] args) {
		System.out.println(new The3SumWithMultiplicity().threeSumMulti(new int[3000],0));	}
}
