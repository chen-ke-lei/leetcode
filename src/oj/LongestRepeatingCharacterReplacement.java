package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		if (s == null)
			return 0;
		if (s.length() == 0 || k >= s.length())
			return s.length();
		int res = 0;
		Map<Character, Integer> charNum = new HashMap<>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (!charNum.containsKey(c)) {
				charNum.put(c, 1);
			}
			charNum.put(c, charNum.get(c) + 1);
		}
		for (char c : charNum.keySet()) {
			chars = s.toCharArray();
			List<Integer> nonc = new ArrayList<>();
			for (int i = 0; i < chars.length; i++)
				if (c != chars[i])
					nonc.add(i);
			if (nonc.size() <= k)
				return s.length();
			
		}
		return res;
	}

	int dfs(List<Integer> nonc, int k) {
		if(k==0) {
			int tmp=0;
			int index=0;
		}
		return  0;
	}
}
