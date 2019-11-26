package oj.tree;

public class ThreadTreeNode {
    public ThreadTreeNode left;
    public ThreadTreeNode right;
    public int value;
    public int ltag;
    public int rTag;

    @Override
    public String toString() {
        String msg = null;
        if (left != null && ltag == 0)
            msg += left.toString();
        msg += "   node[" + ltag + "|" + value + "|" + rTag + "]   ";
        if (rTag == 0 && right != null)
            msg += right.toString();
        return msg;
    }
}
