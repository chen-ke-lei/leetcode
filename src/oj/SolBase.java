package oj;

import java.util.Random;

public class SolBase {
	int rand7() {
		Random random = new Random();
		return random.nextInt(7) + 1;
	}

	class Solution extends SolBase {
		public int rand10() {
			if (rand6() <= 3)
				return rand5();
			return 5 + rand5();
		}

		public int rand6() {
			int num;
			while ((num = rand7()) == 7) {
			
			}
			return num;
		}

		public int rand5() {
			int num;
			while ((num = rand6()) == 6) {
				
			}
			return num;
		}
	}
}
