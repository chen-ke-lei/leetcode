package oj;

import java.util.Arrays;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length <= 1)
			return asteroids;
		int amount = 0;
		for (int i = 1; i < asteroids.length; i++) {
			if (amount < 0) {
				amount = 0;
				asteroids[0] = asteroids[i];
				continue;
			}
			if (asteroids[amount] > 0 && asteroids[i] < 0) {
				if (asteroids[amount] > 0 && asteroids[i] < 0) {
					if (asteroids[i] + asteroids[amount] == 0) {
						amount--;
					} else if (asteroids[i] + asteroids[amount] > 0) {
					} else {
						asteroids[amount] = asteroids[i];
						int tmp = amount - 1;
						while (tmp >= 0 && asteroids[tmp] > 0 && asteroids[amount] < 0) {
							if (asteroids[tmp] + asteroids[amount] == 0) {
								amount -= 2;
								break;
							} else if (asteroids[tmp] + asteroids[amount] < 0) {
								asteroids[tmp] = asteroids[amount];
								amount = tmp;
								tmp = tmp - 1;
							} else {
								amount = tmp;
								break;
							}
						}
					}

				}
				continue;
			}
			asteroids[++amount]=asteroids[i];
		}
		amount = amount < 0 ? -1 : amount;
		int[] res = new int[amount + 1];
		for (int i = 0; i <= amount; i++)
			res[i] = asteroids[i];
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(new int[] { -2,1,-2,-1 })));
	}
}
