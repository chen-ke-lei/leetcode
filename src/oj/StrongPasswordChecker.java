package oj;

import java.util.ArrayList;
import java.util.List;

public class StrongPasswordChecker {

	public int strongPasswordChecker(String s) {
		s = s == null ? "" : s;
		if (s.length() < 6) {
			return minStep(s);
		} else if (s.length() >= 6 && s.length() <= 20) {
			return mediumStep(s);
		} else {
			return upStep(s);
		}

	}

	// 删除到最精简的状态
	// 删除的逻辑 优先级 优先删除 为3的倍数删一个
	// 删连续
	int upStep(String s) {
		List<String> resString = new ArrayList<>();
		boolean num = false;
		boolean lowCase = false;
		boolean upCase = false;
		char pre = ' ';
		int repeat = 1;
		int replaceNum = 0;
		int deleteNum = s.length() - 20;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (mode(s.charAt(i))) {
				case 1:
					num = true;
					break;
				case 2:
					lowCase = true;
					break;
				case 3:
					upCase = true;
					break;
				default:
					break;
			}
			if (c == pre) {
				repeat++;
			} else {
				pre = c;
				if (repeat >= 3 && repeat % 3 == 0) {
					deleteNum--;
					repeat--;
				}
				if (repeat >= 3) {
					resString.add(s.substring(i - repeat , i));
				}
				repeat = 1;
			}
		}
		if (repeat >= 3) {
			if (repeat % 3 == 0) {
				repeat--;
				deleteNum--;
			}
			if (repeat >= 3) {
				resString.add(s.substring(s.length() - repeat ));
			}
		}
		if (resString.isEmpty()) {
			if (deleteNum < 0) {
				replaceNum = deleteNum * (-1);
			}
		} else {
			for (String str : resString) {
				int length = str.length();
				System.out.println(length);
				if (deleteNum > 0) {
					if (length - 2 <= deleteNum) {
						deleteNum -= (length - 2);
					} else {
						length -= deleteNum;
						deleteNum = 0;
						replaceNum += length / 3;

					}
				} else if (deleteNum == 0) {
					replaceNum += length / 3;
				}
			}
			if (deleteNum < 0)
				replaceNum -= deleteNum;
		}
		int x = 0;
		if (!num)
			x++;
		if (!lowCase)
			x++;
		if (!upCase)
			x++;
		return Math.max(x, replaceNum) + s.length() - 20;
	}

	// 在可以不删除或者插入的情况下，应该是优先替换,
	int mediumStep(String s) {
		boolean num = false;
		boolean lowCase = false;
		boolean upCase = false;
		char pre = ' ';
		int repeat = 0;
		int subStep = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == pre) {
				repeat++;
			} else {
				repeat = 0;
			}
			if (repeat == 2) {
				subStep++;
				repeat = 0;
				pre = ' ';
			} else {
				pre = c;
			}
			switch (mode(s.charAt(i))) {
				case 1:
					num = true;
					break;
				case 2:
					lowCase = true;
					break;
				case 3:
					upCase = true;
					break;
				default:
					break;
			}
		}

		int x = 0;
		if (!num)
			x++;
		if (!lowCase)
			x++;
		if (!upCase)
			x++;
		return Math.max(x, subStep);
	}

	// 小于6的情况很好判断
	int minStep(String s) {
		boolean num = false;
		boolean lowCase = false;
		boolean upCase = false;
		for (int i = 0; i < s.length(); i++) {
			switch (mode(s.charAt(i))) {
				case 1:
					num = true;
					break;
				case 2:
					lowCase = true;
					break;
				case 3:
					upCase = true;
					break;
				default:
					break;
			}
		}
		int x = 0;
		if (!num)
			x++;
		if (!lowCase)
			x++;
		if (!upCase)
			x++;
		return Math.max(x, 6 - s.length());
	}

	int mode(char c) {
		if (c >= '0' && c <= '9')
			return 1;
		if (c >= 'a' && c <= 'z')
			return 2;
		if (c >= 'A' && c <= 'Z')
			return 3;
		return 0;
	}

	public static void main(String[] args) {
		StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
		System.out.println(strongPasswordChecker.strongPasswordChecker("aaaaabbbb1234567890ABA"));
	}
}
