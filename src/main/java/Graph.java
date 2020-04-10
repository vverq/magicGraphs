import java.util.ArrayList;


class Graph
{
    private int m_verticesCount;
    private ArrayList m_adjacencyList;
    private Integer[][] m_adjacencyMatrix;

    Graph(ArrayList adjacencyList, Integer[][] adjacencyMatrix)
    {
        m_adjacencyList = adjacencyList;
        m_adjacencyMatrix = adjacencyMatrix;
    }

    int getVertecicesCount()
    {
        return m_verticesCount;
    }

    Integer[][] getAdjacencyMatrix()
    {
        if (m_adjacencyMatrix != null)
        {
            m_verticesCount = m_adjacencyMatrix.length;
            return m_adjacencyMatrix;
        }
        return AdjacencylistToMatrix(m_adjacencyList);
    }

    private Integer[][] AdjacencylistToMatrix(ArrayList m_adjacencyList)
    {
        // TODO: реализовать метод, который превращал бы список смежности в матрицу смежности
        return null;
    }
}
