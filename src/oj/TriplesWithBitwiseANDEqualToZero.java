package oj;

import java.util.ArrayList;
import java.util.List;

public class TriplesWithBitwiseANDEqualToZero {
	public int countTriplets(int[] A) {
		long res = 0;
		List<Integer> nonZeroList = new ArrayList<>();
		int zeroNum = 0;
		int length = A.length;
		for (int i : A) {
			if (i == 0)
				zeroNum++;
			nonZeroList.add(i);
		}
		if (zeroNum > 0)
			res += (length * length * zeroNum - length * zeroNum * (zeroNum - 1) / 2);
		zeroNum = 0;
		length = 0;
		return (int) res;
	}
}
