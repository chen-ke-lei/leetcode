package oj.interview_tips;

public class Q08_05 {
    public int multiply(int A, int B) {
        return Math.min(A, B) == 1 ?
                Math.max(A, B) :
                (Math.max(A, B) + multiply(Math.min(A, B) - 1, Math.max(A, B)));
    }
}
