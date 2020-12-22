package oj.top100.review01;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int size1 = 1, size = 0;
        deque.addFirst(root);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode head = deque.removeLast();
            size1--;
            integers.add(head.val);
            if (head.left != null) {
                size++;
                deque.addFirst(head.left);
            }
            if (head.right != null) {
                deque.addFirst(head.right);
                size++;
            }
            if (size1 == 0) {
                size1 = size;
                size = 0;
                res.add(integers);
                integers = new ArrayList<>();
            }
        }
        return res;
    }
}
