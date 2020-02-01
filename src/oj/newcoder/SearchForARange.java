package oj.newcoder;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int begin = -1;
        int length = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target && begin == -1)
                begin = i;
            else if (A[i] == target && begin != -1)
                length++;
            else if (A[i] != target && begin != -1)
                break;
        }
        res[0] = begin;
        if(begin==-1)
            res[1]=-1;
        else
            res[1]=begin+length;
        return res;
    }
}
