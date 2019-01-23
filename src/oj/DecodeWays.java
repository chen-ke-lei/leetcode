package oj;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null)
			s = "";
		if (s.startsWith("0"))
			return 0;
		if (s.length() <= 1)
			return s.length();
		int[] nums = new int[s.length() + 1];
		nums[1] = 1;
		nums[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			int tmp = 0;
			if (s.charAt(i) != '0') {
				tmp += nums[i];
			}
			if (s.charAt(i - 1) != '0') {
				if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) {
					tmp += nums[i - 1];
				}
			}

			nums[i + 1] = tmp;
		}
		return nums[nums.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("100"));

	}
}
