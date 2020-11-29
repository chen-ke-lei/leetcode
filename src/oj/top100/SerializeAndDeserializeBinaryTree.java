package oj.top100;

import oj.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        new Codec().deserialize("[]");
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuffer buffer = new StringBuffer();
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(root);
        while (!pre.isEmpty()) {
            for (TreeNode node : pre) {
                if (node != null) {
                    buffer.append(node.val + ",");
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    buffer.append("null,");
                }
            }
            pre=next;
            next=new ArrayList<>();

        }
        buffer.deleteCharAt(buffer.length()-1);

        return "[" + buffer.toString() + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data=data.substring(1,data.length()-1);
        String[] nodes=data.split(",");
        if(data.trim().length()==0)
            return null;
        if(nodes.length==0)
            return null;
        TreeNode root=new TreeNode(Integer.valueOf(nodes[0]));
        int index=0;
        List<TreeNode> pre = new ArrayList<>(), next = new ArrayList<>();
        pre.add(root);
        for(int i=1;i<nodes.length;i++){
            if(index/2>=pre.size()){
                pre=next;
                next=new ArrayList<>();
                index=0;
            }
            TreeNode node=pre.get(index/2);
            if(!"null".equals(nodes[i])){
                TreeNode newNode=new TreeNode(Integer.valueOf(nodes[i]));
                if(index%2==0)
                    node.left=newNode;
                else
                    node.right=newNode;
                next.add(newNode);
            }
            index++;
        }
        return root;
    }
}