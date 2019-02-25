package oj;

import java.util.Stack;

import oj.dto.NestedInteger;

public class MiniParser {
	public NestedInteger deserialize(String s) {
		NestedInteger nestedInteger = new NestedInteger();
		int beginIndex = 0;
		int endStep = 0;
		boolean hasSub = false;
		boolean isSingle = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				hasSub = true;
				endStep++;
			} else if (c == ']') {
				endStep--;
			} else if (c == ',') {
				if (endStep == 0) {
					if (hasSub) {
						nestedInteger.add(deserialize(s.substring(beginIndex + 1, i)));
					} else {
						if (isSingle) {
							
						} else {

						}
					}
					beginIndex = i + 1;
					hasSub = false;
					isSingle = false;
				}
			}
		}
		return nestedInteger;
	}
}
