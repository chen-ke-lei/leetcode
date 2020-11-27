package oj.hot200;

public class Q255 {
    public boolean verifyPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    boolean dfs(int[] preorder, int i, int j) {
        if (i >= j) return true;
        int sub = -1;
        for (int k = i + 1; k <= j; k++) {
            if (preorder[k] > preorder[i]) {
                if (sub == -1) {
                    sub = k;
                }
            } else if (sub != -1) return false;
        }
        if (sub == -1) sub = j + 1;
        if (!dfs(preorder, i + 1, sub - 1)) return false;
        if (!dfs(preorder, sub, j)) return false;


        return true;
    }
}
