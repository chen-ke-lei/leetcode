package oj.top100.review01;

public class Q647 {
    public int countSubstrings(String s) {
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                } else
                    break;
            }
            left = i;
            right = i + 1;
            while (left>=0&&right<s.length()){
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                } else
                    break;
            }
        }

        return res;
    }
}
