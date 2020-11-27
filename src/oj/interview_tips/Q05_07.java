package oj.interview_tips;

public class Q05_07 {
    public int exchangeBits(int num) {
        int x = 0b01010101010101010101010101010101;
        int y = x <<= 1;
        return ((num >> 1) & x) | ((num << 1) & y);
    }
}
