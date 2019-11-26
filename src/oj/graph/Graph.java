package oj.graph;

import java.util.List;

public interface Graph {

    boolean adjacend(GraphNode begin,GraphNode end);

    List<Verge> Neighbors(GraphNode node);

    void InsertNode(GraphNode node);

    void deleteDode(GraphNode node);

    void addEdge(GraphNode begin, GraphNode end);

    GraphNode firstNeighbor(GraphNode node);

    int getEdgeValue(GraphNode begin, GraphNode end);

    void setEdgeValue(GraphNode begin, GraphNode end, int value);
}
