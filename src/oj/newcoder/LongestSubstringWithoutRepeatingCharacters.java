package oj.newcoder;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] a){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, length = 0,end=0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))||map.get(s.charAt(i))<end) {
                length++;

            } else {
                maxLength = maxLength > length ? maxLength : length;
                end=map.get(s.charAt(i));
                length = i - map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i);
        }
        maxLength = maxLength > length ? maxLength : length;
        return maxLength;
    }
}
