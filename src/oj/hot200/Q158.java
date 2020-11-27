package oj.hot200;

public class Q158 {
}

class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    char[] buf4 = new char[4];
    int offSet = 4, length = 4;

    public int read(char[] buf, int n) {
        //   if(length==0)return 0;
        for (int i = 0; i < n; i++) {
            if (length == offSet) {
                length = read4(buf4);
                offSet = 0;
                if (length == 0) return i;


            }
            buf[i] = buf4[offSet++];
        }
        return n;
    }
}

class Reader4 {
    int read4(char[] buf) {
        return 4;
    }
}