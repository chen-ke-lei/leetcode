package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";
		String res = "";
		List<String> subs = new ArrayList<>();
		int zeroBegin = -1;
		int noneZeroBegin = -1;
		for (int i = 0; i < num.length(); i++) {
			if (zeroBegin != -1 && num.charAt(i) != '0') {
				subs.add(num.substring(zeroBegin, i));
				zeroBegin = -1;
				noneZeroBegin = i;
			} else if (noneZeroBegin != -1 && num.charAt(i) == '0') {
				subs.add(num.substring(noneZeroBegin, i));
				noneZeroBegin = -1;
				zeroBegin = i;
			} else if (num.charAt(i) == '0' && zeroBegin == -1) {
				zeroBegin = i;
			} else if (num.charAt(i) != '0' && noneZeroBegin == -1) {
				noneZeroBegin = i;
			}
		}
		if (zeroBegin != -1) {
			subs.add(num.substring(zeroBegin));
		} else if (noneZeroBegin != -1) {
			subs.add(num.substring(noneZeroBegin));
		}
		int index = 0;
		while (k >= 0) {
			if (index >= subs.size())
				return "0";
			String str = subs.get(index);

			if (str.startsWith("0")) {
				index++;
				continue;
			}
			if (k >= str.length()) {
				index++;
				k -= str.length();
			} else {
				if (k == 0)
					break;
				String resTmp = "";
				int minIndex = -1;
				char minChar = str.charAt(0);
				k = str.length() - k;
				for (int i = k; i > 0; i--) {
					minIndex++;
					int j = minIndex;
					minChar = str.charAt(minIndex);
					for (; j <= str.length() - i; j++) {
						if (str.charAt(j) < minChar) {
							minChar = str.charAt(j);
							minIndex = j;
						}
					}
					resTmp += minChar;
				}
				subs.set(index, resTmp);
				break;
			}
		}
		for (int i = index; i < subs.size(); i++) {
			res += subs.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		RemoveKDigits removeKDigits = new RemoveKDigits();
		System.out.println(removeKDigits.removeKdigitsPer("321056", 4));
	}

	public String removeKdigitsPer(String num, int k) {
		int digits = num.length() - k;
		char[] stk = new char[num.length()];
		int top = 0;
		// k keeps track of how many characters we can remove
		// if the previous character in stk is larger than the current one
		// then removing it will get a smaller number
		// but we can only do so when k is larger than 0
		// 这套思路比我好的不少,我看了10分钟才看懂
		for (int i = 0; i < num.length(); ++i) {
			char c = num.charAt(i);
			while (top > 0 && stk[top - 1] > c && k > 0) {
				top -= 1;
				k -= 1;
			}
			stk[top++] = c;
			System.out.println(Arrays.toString(stk));
		}
		// find the index of first non-zero digit
		int idx = 0;
		while (idx < digits && stk[idx] == '0')
			idx++;
		return idx == digits ? "0" : new String(stk, idx, digits - idx);
	}
}
// "1432219"
// 3
