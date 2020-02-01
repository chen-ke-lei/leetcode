package oj.newcoder.todo;

import oj.newcoder.LongestSubstringWithoutRepeatingCharacters;

// TODO: 2020/2/1
public class LongestValidParentheses {
    public static void main(String[] av){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("()(()"));
    }
    public int longestValidParentheses(String s) {
        int maxLength = 0, length = 0, stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack++;
            else if (s.charAt(i) == ')') {
                if (stack > 0) {
                    length += 2;
                    maxLength = length > maxLength ? length : maxLength;
                    stack--;
                } else {
                    maxLength = length > maxLength ? length : maxLength;
                    length = 0;
                }

            }
        }
        if (stack == 0)
            maxLength = length > maxLength ? length : maxLength;
        return maxLength;
    }
}
