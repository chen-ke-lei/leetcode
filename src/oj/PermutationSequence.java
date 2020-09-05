package oj;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] numbers = new int[n];
        StringBuffer res = new StringBuffer();
        int tmp = 1;
        for (int i = 1; i < n; i++) {
            tmp *= i;
        }

        for (int i = n - 1; i >= 1; i--) {
            int num = k / tmp;
            if (k % tmp == 0)
                num -= 1;
            k -= (num * tmp);
            tmp /= i;
            for (int j = 0; j < n; j++) {
                if (numbers[j] != 0)
                    continue;
                if (num == 0) {
                    res.append(j + 1);
                    numbers[j] = -1;
                    break;
                } else
                    num--;
            }

        }
        for (int j = 0; j < n; j++) {
            if (numbers[j] == 0) {
                res.append(j + 1);
                break;
            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3, 3);
    }
}
