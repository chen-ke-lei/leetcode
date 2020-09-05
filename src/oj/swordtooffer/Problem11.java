package oj.swordtooffer;

public class Problem11 {
    public static void main(String[] av) {
        Problem11 p = new Problem11();
        p.minArray(new int[]{10, 1, 10, 10, 10});
    }


    public int minArray(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        if (numbers[0] < numbers[numbers.length - 1])
            return numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i])
                return numbers[i + 1];
        }
        return numbers[0];
    }

}
