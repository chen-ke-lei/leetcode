package oj;

public class FruitIntoBaskets {
	public int totalFruit(int[] tree) {
		if (tree.length <= 2)
			return tree.length;
		int fa = -1, fb = -1, lastStart = -1, res = 0, tmp = 0;
		for (int i = 0; i < tree.length; i++) {
			int num = tree[i];
			if (fa == -1) {
				fa = num;
				lastStart = i;
				tmp++;
			} else if (num == tree[lastStart]) {
				tmp++;
			} else if (fb == -1) {
				fb = num;
				lastStart = i;
				tmp++;
			} else if (num == fa || num == fb) {
				tmp++;
				fa = fb;
				fb=num;
				lastStart = i;
			} else {
				res = tmp > res ? tmp : res;
				fa = fb;
				fb = num;
				tmp = i - lastStart + 1;
				lastStart = i;
			}
//			System.out.println(lastStart + "  " + fa + "   " + fb);
//			System.out.println(tmp);
//			System.out.println();
		}
		return res > tmp ? res : tmp;
	}

	public static void main(String[] args) {
		System.out.println(new FruitIntoBaskets().totalFruit(new int[] { 1, 0, 1, 4, 1, 4, 1, 2, 3 }));
	}
}
