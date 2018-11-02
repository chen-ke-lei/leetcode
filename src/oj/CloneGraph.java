package oj;

import java.util.HashMap;
import java.util.Map;

import oj.dto.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<>();
		cloneMap.put(node, copy);
		dfs(node, cloneMap);
		return copy;
	}

	void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
		for (UndirectedGraphNode node1 : node.neighbors) {
			if (cloneMap.containsKey(node1)) {
				cloneMap.get(node).neighbors.add(cloneMap.get(node1));
				continue;
			}

			UndirectedGraphNode copyNode = new UndirectedGraphNode(node1.label);
			cloneMap.get(node).neighbors.add(copyNode);
			cloneMap.put(node1, copyNode);
			dfs(node1, cloneMap);
		}
	}
}
