package oj.top100.review01;

public class Q394 {
    public String decodeString(String s) {
   //     System.out.println(s);
        if (s.indexOf(']') == -1) return s;
        int start = 0;
        int stack = 0;
        String num = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (stack == 0 && (s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ']' && s.charAt(i) != '[') {
                builder.append(s.charAt(i));
                start = i + 1;
            } else if (s.charAt(i) == '[' && stack == 0) {
                stack++;
                num = s.substring(start, i);
        //        System.out.println(num);
                start = i + 1;
            } else if (s.charAt(i) == '[') stack++;
            else if (s.charAt(i) == ']') {
                stack--;
                if (stack == 0) {
                    String tmp = decodeString(s.substring(start, i));
                    int a = new Integer(num);
                    for (int j = 0; j < a; j++) builder.append(tmp);
                    start = i + 1;
                    stack = 0;
                }
            }
        }
        if (start < s.length()) builder.append(s.substring(start));
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q394().decodeString("3[a2[c]]"));
    }
}
