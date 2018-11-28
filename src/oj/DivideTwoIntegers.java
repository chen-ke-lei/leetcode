package oj;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		long res1 = dividend;
		long res2 = divisor;
		if (dividend == 0)
			return 0;
		boolean lower = false;
		if (dividend < 0) {
			res1 = sub1(dividend);
			lower = !lower;
		}
		if (divisor < 0) {
			res2 = sub1(divisor);
			lower = !lower;
		}

		if (res2 == 1) {
			long res = lower ? sub1(res1) : res1;
			if (res < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			if (res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}

		int res = 0;
		while (res1 >= res2) {

			long tmpres = 1;
			long sub = res2;
			long tmp = res1 >> 1;
			while (sub < tmp) {
				sub <<= 1;
				tmpres <<= 1;
			}
			res1 -= sub;
			res += tmpres;
		}
		System.out.println(res);
		return lower ? (int) sub1(res) : res;
	}

	long sub1(long i) {
		return ~(i) + 1;
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
	}
}
