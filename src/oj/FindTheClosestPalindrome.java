package oj;

public class FindTheClosestPalindrome {
	public String nearestPalindromic(String n) {
		if (Long.valueOf(n)<=10)
			return Long.valueOf(n)-1+"";
		String pa1 = n.substring(0, (n.length() + 1) / 2);
		for (int i = n.length() / 2 - 1; i >= 0; i--) {
			pa1 += n.charAt(i);
		}
		Long nLong = Long.valueOf(n);
		Long tmp1 = Long.valueOf(pa1);
		Long tmp2;

		if (tmp1.equals( nLong)) {
			tmp1=nextMin(n);
			tmp2=nextMax(n);
		} else if (tmp1 > nLong) {
			// 找到<nlong的最大数
			tmp2 = nextMin(n);
		} else {
			// 找到> nlong 的最小数
			tmp2 = nextMax(n);
		}
		long sub1 = Math.abs(nLong - tmp1);
		long sub2 = Math.abs(nLong - tmp2);
		System.out.println(tmp1);
		System.out.println(tmp2);
		return (sub2 == sub1 ? Math.min(tmp1, tmp2) : (sub1 < sub2 ? tmp1 : tmp2)) + "";
	}

	Long nextMin(String n) {
		if (Long.valueOf(n) <= 10) {
			return Long.valueOf(n) - 1;
		}
		String sub1 = n.substring(0, (n.length() + 1) / 2);
		String sub2 = n.substring((n.length()) / 2);
		String resvers = new StringBuffer(sub1).reverse().toString();
		if (Long.valueOf(resvers) < Long.valueOf(sub2)) {
			return Long.valueOf(sub1 + n.substring((n.length()) / 2, (n.length() + 1) / 2) + resvers);
		} else {
			Long tmp = Long.valueOf(sub1);
			String sub1Str = tmp - 1 + "";
			if (sub1Str.length() == sub1.length()) {
				if (sub1.length() * 2 == n.length()) {
					return Long.valueOf(sub1Str + new StringBuffer(sub1Str).reverse().toString());
				} else {
					return Long.valueOf(sub1Str
							+ new StringBuffer(sub1Str.substring(0, sub1Str.length() - 1)).reverse().toString());
				}
			} else {
				sub1 = "";
				for (int i = 0; i < n.length() - 1; i++)
					sub1 += '9';
				return Long.valueOf(sub1);
			}

		}
	}

	Long nextMax(String n) {

		String sub1 = n.substring(0, (n.length() + 1) / 2);
		String sub2 = n.substring((n.length()) / 2);
		String resvers = new StringBuffer(sub1).reverse().toString();
		if (Long.valueOf(resvers) > Long.valueOf(sub2)) {
			return Long.valueOf(sub1 + n.substring((n.length()) / 2, (n.length() + 1) / 2) + resvers);
		} else {
			Long tmp = Long.valueOf(sub1);
			String sub1Str = tmp + 1 + "";
			if (sub1Str.length() == sub1.length()) {
				if (sub1.length() * 2 == n.length()) {
					return Long.valueOf(sub1Str + new StringBuffer(sub1Str).reverse().toString());
				} else {
					return Long.valueOf(sub1Str
							+ new StringBuffer(sub1Str.substring(0, sub1Str.length() - 1)).reverse().toString());
				}
			} else {
				sub1 = "1";
				for (int i = 1; i < n.length() ; i++)
					sub1 += '0';
				sub1 += '1';
				return Long.valueOf(sub1);
			}

		}
	}

	public static void main(String[] args) {
		System.out.println(new FindTheClosestPalindrome().nearestPalindromic("999"));
	}
}
