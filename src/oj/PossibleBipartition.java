package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		boolean[] status = new boolean[N];
		List<List<Integer>> sites = new ArrayList<>();
		for (int i = 0; i < N; i++)
			sites.add(new ArrayList<>());
		for (int[] site : dislikes) {
			sites.get(site[0] - 1).add(site[1] - 1);
			sites.get(site[1] - 1).add(site[0] - 1);
		}
		System.out.println(sites);
		List<Integer> tmp = new ArrayList<>(), pre = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (status[i] == true)
				continue;
			tmp = new ArrayList<>();
			tmp.add(i);
			status[i]=true;
			while (tmp.size() > 0) {
				for (int index = 0; index < tmp.size(); index++) {
					List<Integer> child = sites.get(tmp.get(index));
					for (Integer ponit : child) {
						System.out.println(Arrays.toString(status));
						System.out.println(ponit+"   "+tmp.get(index));
						if (status[ponit] == true&&ponit!=tmp.get(index))
							return false;
						status[ponit] = true;
						pre.add(ponit);
					}
				}
				tmp = pre;
				pre = new ArrayList<>();

			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out
				.println(new PossibleBipartition().possibleBipartition(4, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } }));
	}
}
