package oj.swordtooffer;

public class Problem33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1)
            return true;
        return sub(postorder, 0, postorder.length - 1);
    }

    boolean sub(int[] postorder, int bg, int end) {
        if (bg == end || bg + 1 == end || bg > end) return true;
        int sub = -1;
        int i = end - 1;
        for (; i >= bg; i--) {
            if (sub != -1 && postorder[i] > postorder[end]) return false;
            if (sub == -1 && postorder[i] < postorder[end]) sub = i;
        }
        if (sub == -1)
            return sub(postorder, bg, end - 1);
        else {
            if (!sub(postorder, bg, sub)) return false;
            if (!sub(postorder, sub + 1, end - 1)) return false;
        }
        return true;
    }
}
