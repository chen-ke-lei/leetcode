package oj.hot200;

public class Q1228 {
    public int missingNumber(int[] arr) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 1; i < arr.length; i++) {
            if (a == 0 && b == 0) {
                a = arr[i - 1];
                b = arr[i];
            } else if (arr[i - 1] - arr[i] != a - b) {
                if (c == d) {
                    c = arr[i - 1];
                    d = arr[i];
                } else if (arr[i - 1] - arr[i] == c - d) {
                    return (a + b) / 2;
                }
            } else {
                if (c != d) return (c + d) / 2;
            }
        }
        if (a - b == (c - d) * 2) return (a + b) / 2;
        return (c + d) / 2;
    }
}
