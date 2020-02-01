package oj.newcoder;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length==0)
            return 0;
        if(A.length==1)
            return 1;
        int length=1;
        int last=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]!=last){
                A[length]=A[i];
                length++;
                last=A[i];
            }
        }
        return length;
    }
}
