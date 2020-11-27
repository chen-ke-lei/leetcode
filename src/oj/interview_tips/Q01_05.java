package oj.interview_tips;

public class Q01_05 {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;
        if (first.length() == second.length()) {
            boolean sub = true;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!sub) return false;
                    sub = false;
                }
            }
        } else {
            int max = Math.max(first.length(), second.length());
            String longStr = first.length() == max ? first : second;
            String shortStr = longStr == first ? second : first;
            int step = 0;
            for (int i = 0; i < shortStr.length(); i++) {
                if (shortStr.charAt(i) != longStr.charAt(step + i)) {
                    step++;
                    if (step > 1) break;
                    i--;
                }
            }
            if (step <= 1) return true;

            for (int i = 0; i < shortStr.length(); i++) {
                if (shortStr.charAt(i) != longStr.charAt(i + 1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q01_05().oneEditAway("teacher", "bleacher"));
    }
}
