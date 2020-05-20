import java.util.LinkedList;


class Graph
{
    private int m_verticesCount;
    private int m_edgesCount;
    private Edge[] m_edges;
    private LinkedList<Integer>[] m_adjacencyList;
    private int[][] m_weightMatrix;
    private boolean[][] m_adjacencyMatrix;

    Graph(int verticesCount, LinkedList<Integer>[] adjacencyList, int[][] weightMatrix, boolean[][] adjacencyMatrix)
    {
        m_verticesCount = verticesCount;
        m_adjacencyList = adjacencyList;
        m_weightMatrix = weightMatrix;
        m_adjacencyMatrix = adjacencyMatrix;
    }

    Graph(int verticesCount, int edgesCount)
    {
        m_verticesCount = verticesCount;
        m_edgesCount = edgesCount;
        m_edges = new Edge[m_edgesCount];
        for (int i = 0; i < m_edgesCount; ++i)
            m_edges[i] = new Edge();
    }

    Graph(int[][] adjacencyMatrix)
    {
        m_weightMatrix = adjacencyMatrix;
        m_verticesCount = adjacencyMatrix.length;
    }

    int getVerticesCount()
    {
        return m_verticesCount;
    }

    int getEdgesCount()
    {
        return m_edgesCount;
    }

    Edge[] getM_edges()
    {
        return m_edges;
    }

    void setEdges(Edge[] edges)
    {
        m_edges = edges;
    }

    int[][] getWeightMatrix()
    {
        return m_weightMatrix;
    }

    boolean[][] getAdjacencyMatrix() {
        return m_adjacencyMatrix;
    }

    LinkedList<Integer> getAdjacencyListTo(int vertex)
    {
        // TODO
        return null;
    }

    LinkedList<Integer>[] getAdjacencyList()
    {
        return m_adjacencyList;
    }

    private int[][] AdjacencylistToMatrix(LinkedList<Integer>[] m_adjacencyList)
    {
        // TODO: реализовать метод, который превращал бы список смежности в матрицу смежности
        return null;
    }
}

;