package oj.graph.linkedgraph;

import oj.graph.GraphNode;
import oj.graph.Verge;

import java.util.ArrayList;
import java.util.List;

public class GraphNodeByLinked implements GraphNode {
    VergeByLinked firstNode;


    @Override
    public List<Verge> getVerges() {

        VergeByLinked p = firstNode;
        List<Verge> verges = new ArrayList<>();
        while (p != null) {
            verges.add(p);
            p = p.getNext();
        }
        return verges;
    }

    @Override
    public boolean addVerge(GraphNode node) {
        if (hasVerge(node))
            return false;
        VergeByLinked newVerge = new VergeByLinked(this, (GraphNodeByLinked) node);
        newVerge.setNext(firstNode);
        firstNode = newVerge;
        return true;
    }

    @Override
    public boolean deleteVerge(GraphNode node) {
        if (node == null || firstNode == null)
            return false;
        if (node instanceof GraphNodeByLinked)
            return false;
        if (node.equals(firstNode.getEndNode())) {
            firstNode = firstNode.getNext();
            return true;
        }
        VergeByLinked pre = firstNode, p = firstNode.getNext();
        while (p != null) {
            if (p.getEndNode().equals(node)) {
                pre.setNext(p.getNext());
                return true;
            }
            pre = p;
            p = p.getNext();
        }

        return false;
    }

    @Override
    public boolean hasVerge(GraphNode node) {
        if (node == null || firstNode == null)
            return false;
        VergeByLinked p = firstNode;
        while (p != null) {
            if (p.equals(node)) return true;
            p = p.getNext();
        }
        return false;
    }

}
