package oj;

public class SwapAdjacentInLRString {
	public boolean canTransform(String start, String end) {
		int startIndex = 0, endIndex = 0;
		while (startIndex <= start.length() && endIndex <= end.length()) {
			if (start.charAt(startIndex) == 'X')
				startIndex++;
			else if (end.charAt(endIndex) == 'X')
				endIndex++;
			else if (end.charAt(endIndex) != start.charAt(startIndex))
				return false;
			else {
				startIndex++;
				endIndex++;
			}
		}
		for (; startIndex < start.length(); startIndex++)
			if (start.charAt(startIndex) != 'X')
				return false;
		for (; endIndex < end.length(); endIndex++)
			if (end.charAt(endIndex) != 'X')
				return false;
		return true;
	}
}
