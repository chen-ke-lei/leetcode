package oj;

import java.util.Arrays;

public class FriendsOfAppropriateAges {
	public int numFriendRequests(int[] ages) {
		int res = 0;
		Arrays.sort(ages);
		int tmp = 0;
		for (int i = 0; i < ages.length; i++) {
			if (tmp > 0 && ages[i] == ages[i - 1]) {
				res += tmp;
				if (i == ages.length - 1)
					tmp = 0;
				continue;
			}
			tmp = 0;
			for (int j = i + 1; j < ages.length; j++) {
				if (ages[i] > ages[j] / 2 + 7) {
					tmp++;
					// System.out.println(ages[i]+" "+ages[j]);
				}

				else {
					break;
				}

			}
			res += tmp;
		}
		return res + tmp;
	}

	public static void main(String[] args) {
		new FriendsOfAppropriateAges().numFriendRequests(new int[] { 16, 16 });
	}
}
