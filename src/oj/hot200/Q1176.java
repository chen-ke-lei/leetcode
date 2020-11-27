package oj.hot200;

public class Q1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int length = 0;
        int point = 0;
        int sum = 0;
        for (int i = 0; i < calories.length; i++) {
            length++;
            sum += calories[i];
            if (length < k) continue;
            if (length > k) {
                sum -= calories[i - length + 1];
                length--;
            }
            double tmp = sum / (length * 1.0);
            if (tmp < lower) point--;
            if (tmp > upper) point++;
        }
        return point;
    }
}
