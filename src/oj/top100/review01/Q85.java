package oj.top100.review01;

import java.util.Stack;

public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] x = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    x[i][j] = 1;
                    if (i > 0) x[i][j] += x[i - 1][j];
                }
            }
            max = Math.max(max, findMaxByStack(x[i]));
        }
        return max;
    }

    int findMaxByStack(int[] x) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[x.length];
        int[] right = new int[x.length];
        int max = 0;
        for (int i = 0; i < x.length; i++) {
            while (!stack.isEmpty() && x[stack.peek()] > x[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = x.length ;
        }
        for (int i = 0; i < x.length; i++)
            max = Math.max(max, x[i] * (right[i] - left[i] - 1));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q85().maximalRectangle(new char[][]{{'1'}}));
    }
}
