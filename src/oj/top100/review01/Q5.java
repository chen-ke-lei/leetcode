package oj.top100.review01;

public class Q5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1, right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else
                    break;

            }
            if (right - left - 1 > res.length()) res = s.substring(left + 1, right);
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else
                    break;
            }
            if (right - left - 1 > res.length()) res = s.substring(left + 1, right);
        }
        return res;
    }
}
