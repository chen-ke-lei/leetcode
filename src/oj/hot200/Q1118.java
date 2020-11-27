package oj.hot200;

public class Q1118 {
    public int numberOfDays(int Y, int M) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M != 2) return days[M - 1];
        if (Y % 4 != 0) return 28;
        if (Y % 100 == 0 && Y % 400 != 0) return 28;
        return 29;
    }
}
