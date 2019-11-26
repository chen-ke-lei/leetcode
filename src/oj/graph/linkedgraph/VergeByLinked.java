package oj.graph.linkedgraph;

import oj.graph.GraphNode;
import oj.graph.Verge;

public class VergeByLinked implements Verge {

    GraphNodeByLinked start;

    GraphNodeByLinked end;

    VergeByLinked next;

    public VergeByLinked getNext() {
        return next;
    }

    public void setNext(VergeByLinked next) {
        this.next = next;
    }

    public VergeByLinked(GraphNodeByLinked start, GraphNodeByLinked end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public void setValue(int i) {
    }

    @Override
    public GraphNode getStartNode() {
        return start;
    }

    @Override
    public GraphNode getEndNode() {
        return end;
    }
}
