import java.util.LinkedList;


class Graph
{
    private int m_verticesCount;
    private int m_edgesCount;
    private Edge[] m_edges;
    private LinkedList[] m_adjacencyList;
    private int[][] m_adjacencyMatrix;

    Graph(int verticesCount, LinkedList[] adjacencyList, int[][] adjacencyMatrix)
    {
        m_verticesCount = verticesCount;
        m_adjacencyList = adjacencyList;
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
        m_adjacencyMatrix = adjacencyMatrix;
        m_verticesCount = adjacencyMatrix.length;
    }

    int getVerticicesCount()
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

    int[][] getAdjacencyMatrix()
    {
        if (m_adjacencyMatrix != null)
        {
            m_verticesCount = m_adjacencyMatrix.length;
            return m_adjacencyMatrix;
        }
        return AdjacencylistToMatrix(m_adjacencyList);
    }

    LinkedList[] getAdjacencyList()
    {
        return m_adjacencyList;
    }

    private int[][] AdjacencylistToMatrix(LinkedList[] m_adjacencyList)
    {
        // TODO: реализовать метод, который превращал бы список смежности в матрицу смежности
        return null;
    }
}

;
