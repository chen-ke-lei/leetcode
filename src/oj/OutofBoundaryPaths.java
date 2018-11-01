package oj;

public class OutofBoundaryPaths {

	public int findPathsLow(int m, int n, int N, int i, int j) {
		if (i >= m || j >= n || N == 0)
			return 0;
		int res = 0;

		return dfs(m, n, N, i, j);
	}

	int dfs(int m, int n, int N, int i, int j) {
		int left = 0, right = 0, up = 0, down = 0;
		if (N == 0)
			return 0;
		left = (i == 0) ? 1 : dfs(m, n, N - 1, i - 1, j);
		right = (i == m - 1) ? 1 : dfs(m, n, N - 1, i + 1, j);
		up = (j == n - 1) ? 1 : dfs(m, n, N - 1, i, j + 1);
		down = (j == 0) ? 1 : dfs(m, n, N - 1, i, j - 1);
		return (left + right + up + down) % (1000000007);
	}

	public int findPaths(int m, int n, int N, int i, int j) {
		if (i >= m || j >= n || N == 0 || m == 0 || n == 0)
			return 0;
		long res = 0;
		long[][] pre = new long[m][n], next = new long[m][n];
		pre[i][j] = 1;
		for (int step = 0; step <N; step++) {
			for (int x = 0; x < m; x++) {
				for (int y = 0; y < n; y++) {
					if (pre[x][y] != 0) {		
						long tmp= pre[x][y]%1000000007;
						if (x < m - 1)
							next[x + 1][y] += tmp;
						else
							res += tmp;
						if (x >0)
							next[x - 1][y] += tmp;
						else
							res += tmp;
						if (y >0)
							next[x][y - 1] +=tmp;
						else
							res += tmp;
						if (y <n-1)
							next[x][y + 1] += tmp;
						else
							res += tmp;
						res%=1000000007;
					}
				
				}
			}
		
			pre=next;
			next=new long[m][n];
		}
		return (int)(res%=1000000007);
	}

	public static void main(String[] args) {
		OutofBoundaryPaths outo = new OutofBoundaryPaths();
		//System.out.println(outo.findPathsLow(8, 50, 23, 5, 26));
		System.out.println(outo.findPaths(8, 50, 23, 5, 26));
	}
}
