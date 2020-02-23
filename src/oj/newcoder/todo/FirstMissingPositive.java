package oj.newcoder.todo;

// TODO: 2020/2/2  
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i || A[i] < 0 || A[i] > A.length - 1)
                continue;
            int tmp = A[i];
            while (tmp > 0 && tmp < A.length) {
                int a = A[tmp];
                A[tmp] = A[i];
                tmp = a;

            }
            A[i] = -1;
        }
        for (int i = 1; i < A.length; i++)
            if (A[i] != i)
                return i;
        return A.length;
    }

}
