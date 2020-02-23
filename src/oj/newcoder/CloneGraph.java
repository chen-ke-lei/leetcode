package oj.newcoder;

import oj.dto.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        UndirectedGraphNode tmpCopy = null, tmp = null, neg = null;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            tmpCopy = map.get(tmp);
            ArrayList<UndirectedGraphNode> nodes = tmp.neighbors;
            for (int i = 0; i < nodes.size(); i++) {
                neg = map.get(nodes.get(i));
                if (neg == null) {
                    neg = new UndirectedGraphNode(nodes.get(i).label);
                    tmpCopy.neighbors.add(neg);
                    map.put(nodes.get(i), neg);
                    stack.push(nodes.get(i));
                } else {
                    tmpCopy.neighbors.add(neg);
                }
            }
        }


        return copy;
    }
}
