public class UndirectedGraph extends Graph {
    UndirectedGraph(boolean[][] adjacencyMatrix) {
        super(adjacencyMatrix);
    }

    UndirectedGraph(int verticesCount, int edgesCount) {
        super(verticesCount, edgesCount);
    }
}
