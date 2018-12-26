package oj;

import java.util.Stack;

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		if (s == null || s.length() == 0)
			return true;
		int num = 0;
		int starNum = 0;
		Stack<Character> st1 = new Stack<>(), st2 = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			switch (c1) {
				case '(':
					st1.push(c1);
					break;
				case '*':
					st1.push(c1);
					break;
				case ')':
					if (st1.isEmpty())
						return false;
					while (!st1.empty() && st1.peek() == '*') {
						st2.push(st1.pop());
					}
					if (st1.empty())
						st2.pop();
					else
						st1.pop();
					while (!st2.empty()) {
						st1.push(st2.pop());
					}
					break;
				default:
					break;
			}
		}
		s = "";
		while (!st1.empty()) {
			s = st1.pop() + s;

		}
		System.out.println(s);
		for (int i = 0; i < s.length(); i++) {

		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(
				new ValidParenthesisString().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}
}
