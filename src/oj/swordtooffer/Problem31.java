package oj.swordtooffer;

public class Problem31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[popped.length];
        int head = 0, length = 0, j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack[head++] = pushed[i];
            length++;
            while (length > 0 && j < popped.length && popped[j] == stack[head-1]) {
                length--;
                head--;
                j++;

            }
        }
        return length == 0;
    }
}
