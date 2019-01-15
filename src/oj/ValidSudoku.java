package oj;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[] cal = null;
		for (int i = 0; i < 9; i++) {
			cal = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (cal[board[i][j] - '1'])
						return false;
					cal[board[i][j] - '1'] = true;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			cal = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (cal[board[j][i] - '1'])
						return false;
					cal[board[j][i] - '1'] = true;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			int x = i / 3 * 3;
			int y = i % 3 * 3;
			cal = new boolean[9];
			for (int tmpx = 0; tmpx < 3; tmpx++) {
				for (int tmpy = 0; tmpy < 3; tmpy++) {
					if (board[x + tmpx][y + tmpy] != '.') {
						if (cal[board[x + tmpx][y + tmpy] - '1'])
							return false;
						cal[board[x + tmpx][y + tmpy] - '1'] = true;
					}
				}
			}
		}

		return true;

	}
}
