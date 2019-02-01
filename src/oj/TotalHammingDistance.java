package oj;

public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		int res = 0;
		int[] bitNum = new int[32];
		for (int i : nums) {
			int sub = i;
			for (int bit = 0; bit < 32; bit++) {
				if ((sub & 1) == 1) {
					bitNum[bit]++;
				}
				sub >>= 1;
			}
		}
		for (int i = 0; i < 32; i++) {
			res += ((nums.length - bitNum[i]) * bitNum[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] x = new int[] { 4, 14, 2 };
		System.out.println(new TotalHammingDistance().totalHammingDistance(x));
	}
}
