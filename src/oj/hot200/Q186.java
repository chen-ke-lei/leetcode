package oj.hot200;

public class Q186 {
    public void reverseWords(char[] s) {
        int start = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ' && start == -1) start = i;

            if (s[i] == ' ' && start != -1) {
                for (int j = start; j < (i + start) / 2; j++) {
                    char c = s[j];
                    s[j] = s[i - j - 1];
                    s[i - j - 1] = c;
                }
                start = -1;
            }
        }
    }
}
