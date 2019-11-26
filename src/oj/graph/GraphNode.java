package oj.graph;

import java.util.List;

public interface GraphNode {
    List<Verge> getVerges();

    boolean addVerge(GraphNode node);

    boolean deleteVerge(GraphNode node);

    boolean hasVerge(GraphNode node);
}
