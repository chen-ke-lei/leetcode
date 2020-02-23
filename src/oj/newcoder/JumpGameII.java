package oj.newcoder;

public class JumpGameII {
    public static void main(String[] a){
        System.out.println(new JumpGameII().jump(new int[]{1,2}));
    }
    public int jump(int[] A) {
        if (A == null)
            return 0;
        if (A.length < 2)
            return 0;
        int[] step = new int[A.length];
        step[0] = 1;
        for (int i = 0; i < A.length-1; i++) {
            if (step[i] > 0) {
                for (int j = 1; j <= A[i] && j + i < A.length ; j++) {
                    if (step[j+i] == 0)
                        step[j+i] = step[i] + 1;
                    else if (step[j+i] > step[i] + 1)
                        step[j+i] = step[i] + 1;
                }
            }
        }
        return (step[step.length - 1] - 1 )<0 ? 0 : (step[step.length - 1]-1);
    }
}
