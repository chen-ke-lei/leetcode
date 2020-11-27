package oj.interview_tips;

import java.util.Arrays;

public class Q01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return new String(chars).equals(new String(chars1));
    }
}
