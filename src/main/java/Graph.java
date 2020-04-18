import java.util.ArrayList;


class Graph
{
    private int m_verticesCount;
    private ArrayList<ArrayList<Integer>> m_adjacencyList;
    private boolean[][] m_adjacencyMatrix;

    Graph(ArrayList<ArrayList<Integer>> adjacencyList, boolean[][] adjacencyMatrix)
    {
        m_adjacencyList = adjacencyList;
        m_adjacencyMatrix = adjacencyMatrix;
        m_verticesCount = adjacencyList.size();
    }

    public int getVerticesCount()
    {
        return m_verticesCount;
    }

    public boolean[][] getAdjacencyMatrix() { return m_adjacencyMatrix; }

    public ArrayList<ArrayList<Integer>> getAdjacencyList() { return m_adjacencyList; }
}
