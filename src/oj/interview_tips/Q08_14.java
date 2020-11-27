package oj.interview_tips;

import java.util.ArrayList;
import java.util.List;

public class Q08_14 {
    int num = 0;

    public int countEval(String s, int result) {
        List<Character> number = new ArrayList<>(), sign = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1')
                number.add(s.charAt(i));
            else sign.add(s.charAt(i));
        }
        number.sort((a, b) -> a - b);
        sign.sort((a, b) -> a - b);
        boolean[] numVis = new boolean[number.size()];
        char c = '\0';
        for (int i = 0; i < number.size(); i++) {
            if (c != number.get(i)) {
                numVis[i] = true;

                dfs(numVis, new boolean[sign.size()], number, sign, number.get(i) - '0', 1, result);
                numVis[i] = false;
            }
            c = number.get(i);
        }
        return num;
    }

    void dfs(boolean[] numVis, boolean[] signVis, List<Character> number,
             List<Character> sign, int res, int len, int result
    ) {
        if (len == (number.size() + sign.size())) {
            if (res == result)
                num++;
            return;
        }
        char nc = '\0';
        for (int i = 0; i < number.size(); i++) {
            if (numVis[i] == false && nc != number.get(i)) {
                numVis[i] = true;
                char ns = '\0';
                System.out.println(res);
                System.out.println(number.get(i) - '0');
                for (int j = 0; j < sign.size(); j++) {
                    if (signVis[j] == false && ns != sign.get(j)) {
                        signVis[j] = true;
                        int tmp = res;
                        System.out.println(sign.get(j));
                        switch (sign.get(j)) {

                            case '^':
                                tmp ^= (number.get(i) - '0');
                                break;
                            case '|':
                                tmp |= (number.get(i) - '0');
                                break;
                            case '&':
                                tmp &= (number.get(i) - '0');
                                break;
                        }
                        dfs(numVis, signVis, number, sign, tmp, len + 2, result);
                        signVis[j] = false;
                    }

                    ns = sign.get(j);
                }
                numVis[i] = false;
            }
            nc = number.get(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q08_14().countEval("1^0|0|1",
                0));
    }
}
