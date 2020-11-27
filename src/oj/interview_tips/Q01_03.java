package oj.interview_tips;

public class Q01_03 {
    public String replaceSpaces(String S, int length) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                buffer.append("%20");
            } else
                buffer.append(c);
        }
        return buffer.toString();
    }
}
