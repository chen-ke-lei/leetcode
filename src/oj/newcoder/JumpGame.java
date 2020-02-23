package oj.newcoder;


public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null || A.length <2)
            return true;

        boolean[] path = new boolean[A.length];
        path[0] = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (path[i]) {
                for (int j = 1; j <=A[i] && j + i < A.length; j++) {
                    path[i + j] = true;
                }
            }
            if (path[path.length - 1])
                return true;
        }
        return false;
    }
}
