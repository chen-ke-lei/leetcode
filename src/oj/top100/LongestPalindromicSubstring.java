package oj.top100;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int beg = 0, end = 0, max = -1;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (max < right - left - 1) {
                max = right - left - 1;
                beg = left + 1;
                end = right - 1;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (max < right - left - 1) {
                max = right - left - 1;
                beg = left + 1;
                end = right - 1;
            }

        }
        return s.substring(beg, end + 1);
    }
}
