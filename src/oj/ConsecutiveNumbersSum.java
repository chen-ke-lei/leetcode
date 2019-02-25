package oj;

public class ConsecutiveNumbersSum {
	public int consecutiveNumbersSum(int N) {
		int res = 1;
		int i = 2;
		int tmp = getSum(2);
		while (tmp <=N) {
			System.out.println(N - tmp);
			System.out.println(i);
			System.out.println((N - tmp) % i);
			System.out.println();
			if ((N - tmp) % i == 0)
				res++;
			i++;
			tmp = getSum(i);
		}
		return res;
	}

	int getSum(int n) {
		return ((n + 1) * n) / 2;
	}

	public static void main(String[] args) {
		System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
	}
}
