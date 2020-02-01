package oj.newcoder;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A[0] >=target)
            return 0;
        if (A[A.length - 1] < target)
            return A.length;
        int left = 0, right = A.length - 1, medium;
        while (left < right) {
            medium = (left + right) / 2;
            if(medium==left)
                break;
            if (A[medium] < target)
                left = medium;
            else if (A[medium] > target)
                right = medium;
            else
                return medium;
        }

        return left + 1;
    }
}
