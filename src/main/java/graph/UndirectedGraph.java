package graph;

import graph.Graph;

public class UndirectedGraph extends Graph {
    public UndirectedGraph(boolean[][] adjacencyMatrix) {
        super(adjacencyMatrix);
    }

    UndirectedGraph(int verticesCount, int edgesCount) {
        super(verticesCount, edgesCount);
    }
}
