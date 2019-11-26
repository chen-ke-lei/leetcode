package oj.graph.linkedgraph;

import oj.graph.Graph;
import oj.graph.GraphNode;
import oj.graph.Verge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphByLined implements Graph {

    Set<GraphNodeByLinked> nodes;

    public GraphByLined() {
        nodes = new HashSet<>();
    }

    @Override
    public boolean adjacend(GraphNode begin, GraphNode end) {
        if (!nodes.contains(begin))
            return false;
        return begin.hasVerge(end);

    }

    //列出所有的边
    @Override
    public List<Verge> Neighbors(GraphNode node) {
        if (node == null)
            return null;
        return node.getVerges();
    }

    @Override
    public void InsertNode(GraphNode node) {
        if (node == null || !(node instanceof GraphNodeByLinked)) return;
        nodes.add((GraphNodeByLinked) node);
    }

    @Override
    public void deleteDode(GraphNode node) {
        if (node == null || !(node instanceof GraphNodeByLinked)) return;
        nodes.remove((GraphNodeByLinked) node);
    }

    @Override
    public void addEdge(GraphNode begin, GraphNode end) {
        begin.addVerge(end);
        end.addVerge(begin);
    }

    @Override
    public GraphNode firstNeighbor(GraphNode node) {
        return ((GraphNodeByLinked) node).firstNode.getEndNode();
    }

    @Override
    public int getEdgeValue(GraphNode begin, GraphNode end) {
        return 0;
    }

    @Override
    public void setEdgeValue(GraphNode begin, GraphNode end, int value) {

    }
}
