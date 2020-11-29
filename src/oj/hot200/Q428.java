package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q428 {
    public static void main(String[] args) {
        Codec dec = new Codec();
        dec.deserialize("[1[3[5][6]][2][4]]");

    }
}

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(root.val);
        for (Node child : root.children) {
            buffer.append(serialize(child));
        }
        buffer.append("]");
        return buffer.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) return null;
        Node node = new Node();
        node.children = new ArrayList<>();
        data = data.substring(1, data.length() - 1);
        int start = data.indexOf("[");
        if (start == -1) {
            node.val = Integer.valueOf(data);
            return node;
        }
        node.val = Integer.valueOf(data.substring(0, start));
        int stack = 1;
        for (int i = start + 1; i < data.length(); i++) {
            if (data.charAt(i) == ']') stack--;
            else if (data.charAt(i) == '[') stack++;
            if (stack == 0) {
                node.children.add(deserialize(data.substring(start, i + 1)));
                start = i + 1;
                stack = 1;
                i++;
            }

        }
        return node;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

