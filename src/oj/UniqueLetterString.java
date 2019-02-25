package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {
	public int uniqueLetterString(String S) {
		if (S == null || S.length() == 0)
			return 0;
		if (S.length() == 1)
			return 1;
		int res = 0;
		int tmp = 0;
		int sub = 0;
		Map<Character, Integer> nowIndex = new HashMap<>();
		Map<Character, List<Integer>> charIndex = new HashMap<>();
		Map<Character, Integer> tmpMap = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (tmpMap.containsKey(c)) {
				if (tmpMap.get(c) == 1)
					sub--;
				tmpMap.put(c, tmpMap.get(c) + 1);
				charIndex.get(c).add(i);
			} else {
				nowIndex.put(c, 0);
				List<Integer> tmpList = new ArrayList<>();
				tmpList.add(i);
				charIndex.put(c, tmpList);
				tmpMap.put(c, 1);
				sub++;
			}
			tmp += sub;
		}
		res += tmp;
		for (int i = 0; i < S.length() - 1; i++) {
			char c = S.charAt(i);
			int index = nowIndex.get(c);
			if (index == (charIndex.get(c).size() - 1)) {
				tmp -= (S.length() - charIndex.get(c).get(index));
				System.out.println(tmp);
			} else if (index < (charIndex.get(c).size() - 1)) {
				tmp -= (charIndex.get(c).get(index + 1) - charIndex.get(c).get(index));
				if (index + 1 < (charIndex.get(c).size() - 1)) {
					tmp += (charIndex.get(c).get(index + 2) - charIndex.get(c).get(index + 1));
				} else {
					tmp += (S.length()  - charIndex.get(c).get(index + 1));
				}
			}
			nowIndex.put(c, index + 1);
			res += tmp;
		}
		return res ;
	}

	public static void main(String[] args) {
		System.out.println(new UniqueLetterString().uniqueLetterString("AAA"));
	}
}
