package oj.interview_tips;

public class Q10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] tmp = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (A[i] > B[j])
                    tmp[index++] = A[i++];
                else
                    tmp[index++] = B[j++];
            } else if (j < n) {
                tmp[index++] = B[j++];
            } else
                tmp[index++] = A[i++];
        }
        for (i = 0; i < m + n; i++)
            A[i] = tmp[i];
    }

}
