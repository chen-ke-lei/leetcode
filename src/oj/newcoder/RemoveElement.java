package oj.newcoder;

public class RemoveElement {
    //        public int removeElement(int[] A, int elem) {
//        int length = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] != elem) {
//                A[length] = A[i];
//                length++;
//            }
//        }
//        return length;
//    }
    public int removeElement(int[] A, int elem) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] != elem)
                left++;
            else if (A[right] == elem)
                right--;
            else {
               A[left]=A[right];
               A[right]=elem;
               left++;
               right--;
            }
        }
        if(left<A.length&&A[left]!=elem)
            left++;
        return left;
    }
}
