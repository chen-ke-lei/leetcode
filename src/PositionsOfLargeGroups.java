import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> res = new ArrayList<>();
		if (S == null || S.length() < 3)
			return res;
		int begin = 0;
		int index = 1;
		char oldC = S.charAt(0);
		for (int i = 1; i < S.length(); i++) {
			char newC = S.charAt(i);
			if (newC == oldC) {
				index++;
			} else {
				if (index >= 3) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(begin);
					tmp.add(begin + index-1);
					res.add(tmp);
				}
				oldC = newC;
				begin = i;
				index = 1;
			}
		}
		if (index >= 3) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(begin);
			tmp.add(begin + index-1);
			res.add(tmp);
		}
		return res;
	}
}
