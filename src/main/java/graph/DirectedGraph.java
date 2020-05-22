package graph;

import java.util.LinkedList;

public class DirectedGraph extends Graph {

    DirectedGraph(boolean[][] adjacencyMatrix) {
        super(adjacencyMatrix);
    }

    DirectedGraph(int verticesCount, int edgesCount)
    {
        super(verticesCount, edgesCount);
    }

    public LinkedList<LinkedList<Integer>> getAdjacencyListsFrom() {
        var adjacencyListsFrom = new LinkedList<LinkedList<Integer>>();
        for (var i = 0; i < getVerticesCount(); i++) {
            adjacencyListsFrom.add(new LinkedList<>());
        }
        var adjacencyMatrix = getAdjacencyMatrix();
        for (var i = 0; i < adjacencyMatrix.length; i++) {
            for (var j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j])
                    adjacencyListsFrom.get(j).add(i);
            }
        }
        return adjacencyListsFrom;
    }

    public LinkedList<LinkedList<Integer>> getAdjacencyListsTo() {
        return getAdjacencyLists();
    }
}
