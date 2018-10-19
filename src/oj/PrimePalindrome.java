package oj;

//大于N的最小回文素数
public class PrimePalindrome {
	public int primePalindrome(int N) {
		if (N == 1)
			return 2;
		int res = getNext(N, false);
		while (!isTrue(res)) {
			res = getNext(res, true);
		}
		return res;
	}

	int getNext(int N, boolean add) {
		boolean isMin = true;
		if (add)
			N += 1;

		if (N < 10)
			return N;
		String nString = N + "";
		char[] numbers = nString.toCharArray();
		for (int i = numbers.length / 2 - 1; i >= 0; i--) {
			if (numbers[i] < numbers[numbers.length - 1 - i]) {
				isMin = false;
				break;
			}
		}
		if (!isMin) {
			int bit = 0;
			for (int i = (numbers.length + 1) / 2 - 1; i >= 0; i--) {
				if (numbers[i] < '9') {
					bit = 0;
					numbers[i]++;
					break;
				}
				numbers[i] = '0';
				bit = 1;
			}
			if (bit == 1) {
				String tmp = "1";
				for (int i = 0; i < numbers.length - 1; i++) {
					tmp += '0';
				}
				tmp += '1';
				return Integer.valueOf(tmp);
			}
		}
		String tmp = "";
		for (int i = 0; i < numbers.length; i++) {
			tmp += numbers[i];
			if (i <= numbers.length / 2 - 1) {
				numbers[numbers.length - i - 1] = numbers[i];
			}
		}
		return Integer.valueOf(tmp);
	}

	boolean isTrue(int N) {
		if (N <= 6) {
			if (N == 4 || N == 6)
				return false;
			return true;
		}
		if (N % 2 == 0 || N % 3 == 0 || N % 6 == 0 || N % 5 == 0)
			return false;
		for (int i = 6; i < Math.pow(N, 0.5); i += 6) {
			if (N % (i + 1) == 0 || N % (i + 5) == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(new PrimePalindrome().getNext(11));
		System.out.println(new PrimePalindrome().primePalindrome(192));
	}
}
