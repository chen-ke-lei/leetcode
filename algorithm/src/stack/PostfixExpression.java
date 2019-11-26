package stack;

import javax.sound.sampled.Mixer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostfixExpression {
    static Map<Character, Integer> pority;

    static {
        pority = new HashMap<>();
        pority.put('+', 1);
        pority.put('-', 1);
        pority.put('*', 2);
        pority.put('/', 2);
        pority.put('(', 0);
        pority.put(')', 100);
    }

    public static String midle2post(String midle) {
        String post = "";
        Stack<Character> s = new Stack<>();
        for (Character c : midle.toCharArray()) {
            if (!pority.containsKey(c)) {
                post += c;
            } else {
                if (s.empty()) {
                    s.push(c);
                } else {
                    if (pority.get(c) == 100) {
                        while (!s.peek().equals('(')) {
                            post += s.pop();
                            System.out.println(1);
                        }
                        s.pop();
                    } else {
                        if (c.equals('(')) {
                            s.push(c);
                        } else if (pority.get(s.peek()) < pority.get(c)) {
                            s.push(c);

                        } else {
                            while (!s.isEmpty() && pority.get(s.peek()) >= pority.get(c))
                                post += s.pop();
                            s.push(c);

                        }
                    }
                }
            }
        }
        while (!s.isEmpty()) {
            post += s.pop();
        }
        return post;
    }

    static int calcPst(String post) {
        int res = 0;
        // String pos = "";
        Stack<Integer> tmp = new Stack<>();
        for (Character c : post.toCharArray()) {
            if (pority.containsKey(c)) {
                int a = tmp.pop();
                int b = tmp.pop();
                switch (c) {
                    case '+':
                        tmp.push(a + b);
                        break;
                    case '-':
                        tmp.push(a - b);
                        break;
                    case '*':
                        tmp.push(a * b);
                        break;
                    case '/':
                        tmp.push(a / b);
                        break;
                    default:
                        System.out.println("error!");
                }
            } else {
                tmp.push(c - 48);
            }
        }
        return tmp.pop();
    }

    public static void main(String[] av) {
        System.out.println('0' - 48);
        System.out.println(calcPst(midle2post("1+2*3+(4*5+6)*7")));
    }
}
