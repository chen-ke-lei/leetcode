package oj.hot200;

import java.util.HashMap;
import java.util.Map;

public class Q246 {
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0) return true;
        if (num.length() == 1 && (num.charAt(0) == '1' || num.charAt(0) == '0'|| num.charAt(0) == '8')) return true;
        if (num.length() % 2 == 1 && num.charAt(num.length() / 2 ) != '0' && num.charAt(num.length() / 2) != '1' && num.charAt(num.length() / 2) != '8')
            return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');
        map.put('9', '6');
        map.put('6', '9');
        for (int i = 0; i < num.length() / 2; i++) {
            if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i))
                return false;
        }
        return true;
    }
}
