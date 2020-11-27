package oj.hot200;

public class Q439 {
    public String parseTernary(String expression) {
        if (expression.indexOf("?") == -1) return expression;
        char c = expression.charAt(0);
        int stack = 1;
        int i = 2;
        for (; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') stack++;
            if (expression.charAt(i) == ':') stack--;
            if (stack == 0) break;
        }
        if (c == 'T') return parseTernary(expression.substring(2, i));
        else return parseTernary(expression.substring(i + 1));
    }
}
