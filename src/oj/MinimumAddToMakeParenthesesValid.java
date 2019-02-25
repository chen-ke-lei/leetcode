package oj;

public class MinimumAddToMakeParenthesesValid {
	public int minAddToMakeValid(String S) {
		int res = 0;
		int stack = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(')
				stack++;
			else
				stack--;
			if (stack < 0) {
				res++;
				stack = 0;
			}
		}
		
		return res+Math.abs(stack);
	}
}
