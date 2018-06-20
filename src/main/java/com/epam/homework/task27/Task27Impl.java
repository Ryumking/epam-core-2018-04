package com.epam.homework.task27;

import java.util.HashSet;
import java.util.Set;

public class Task27Impl implements Task27 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}

class Graph extends Task27.AbstractGraph {

    private Set<Edge> edges = new HashSet<>();

    Graph(int numberNodes) {
        super(numberNodes);
    }

    @Override
    public void addEdge(int first, int second) {
        if (!isEdgeExists(first, second)) {
            edges.add(new Edge(first, second));
        }
    }

    @Override
    public void removeEdge(int first, int second) {
        for (Edge edge : edges) {
            if ((edge.first == first && edge.second == second) || (edge.second == first && edge.first == second)) {
                edges.remove(edge);
                break;
            }
        }
    }

    @Override
    public boolean isEdgeExists(int first, int second) {
        for (Edge edge : edges) {
            if ((edge.first == first && edge.second == second) || (edge.second == first && edge.first == second)) {
                return true;
            }
        }

        return false;
    }

    class Edge {
        private int first;
        private int second;

        Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
