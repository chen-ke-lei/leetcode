package oj;

public class New21Game {

	public double new21Game(int N, int K, int W) {
		long[] times = new long[K + W];
		long amont = 0;
		long total = 0;
		times[0] = 1;
	//	times[1] = 1;
		for (int i = 1; i < times.length; i++) {
			Long tmp = 0L;
			for (int j = Math.min(i - 1, K - 1); j >= 0 && j >= i - W; j--) {
				tmp += times[j];
			}
			times[i] = tmp;
			if (i >= K)
				total += tmp;
			if (i <= N && i >= K)
				amont += tmp;
		}
		return amont / (total * 1.0);
	}

	public static void main(String[] args) {
		System.out.println(new New21Game().new21Game(0, 0, 1));
	}
}
