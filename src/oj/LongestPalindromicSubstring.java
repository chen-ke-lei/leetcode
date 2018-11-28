package oj;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null | s.length() <= 1)
			return s;
		String reString = s.charAt(0) + "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
				if (s.charAt(i - j) != s.charAt(i + j)) {
					if ((j - 1) * 2 + 1 > reString.length())
						reString = s.substring(i - (j - 1), i + j);
					break;
				}
				if ((i - j) == 0 || (i + j) == (s.length() - 1)) {
					if (j * 2 + 1 > reString.length())
						reString = s.substring(i - j, i + j + 1);
				}
			}
			for (int j = 0; i - j >= 0 && i + j + 1 < s.length(); j++) {
				if (s.charAt(i - j) != s.charAt(i + j + 1)) {
					if (j * 2 > reString.length())
						reString = s.substring(i - (j - 1), i + j + 1);
					break;
				}
				if ((i - j) == 0 || (i + j + 1) == (s.length() - 1)) {
					if ((j + 1) * 2 > reString.length())
						reString = s.substring(i - j, i + j + 2);
				}
			}
			if (reString.length() > (s.length() - 2 - i) * 2 + 1)
				return reString;
		}

		return reString;
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
	}

	class Solution {
		public String longestPalindrome(String s) {
			if (s.length() < 1) {
				return "";
			}
			char[] cs = s.toCharArray();
			int[] range = new int[] { 0, 1 };
			for (int i = 0; i < cs.length; i++) {
				i = help(cs, range, i);
			}
			return s.substring(range[0], range[1]);
		}

		private int help(char[] cs, int[] range, int i) {
			int lo = i, hi = i;
			// 找到i后第一个不同处
			while (hi < cs.length - 1 && cs[hi] == cs[hi + 1])
				hi++;
			// 开始比较
			int ret = hi;
			while (lo > 0 && hi < cs.length - 1 && cs[lo - 1] == cs[hi + 1]) {
				lo--;
				hi++;
			}
			// 使range数组保存最大范围
			if ((hi - lo + 1) > (range[1] - range[0])) {
				range[0] = lo;
				range[1] = hi + 1;
			}
			return ret;

		}
	}
}
