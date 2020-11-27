package oj.hot200;

public class Q157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    char[] buf4 = new char[4];
    int start = 4, end = 4;

    public int read(char[] buf, int n) {
        int num = 0;
        while (num < n) {
            if (start == end) {
                if (end < 4) return num;
                end = read4(buf4);
                start = 0;
            }
            if (start != end)
                buf[num++] = buf[start++];
        }
        return num;
    }
}

