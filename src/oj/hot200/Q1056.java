package oj.hot200;

public class Q1056 {
    public boolean confusingNumber(int N) {
        int newNum = 0, oldNum = N;

        while (oldNum > 0) {
            int num = oldNum % 10;
            oldNum /= 10;
            if (num == 2 || num == 3 || num == 4 || num == 5 || num == 7) return false;
            if (num == 6) num = 9;
            else if (num == 9) num = 6;
            newNum = newNum * 10 + num;
        }

        return newNum != N;

    }
}
