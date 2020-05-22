package graph;

import graph.Edge;
import javafx.util.Pair;

import java.util.LinkedList;

public class Graph
{
    private int m_verticesCount;
    private int m_edgesCount;
    private Edge[] m_edges;
    private boolean[][] m_adjacencyMatrix;
    private int[][] m_weightMatrix;

    public Graph(boolean[][] adjacencyMatrix)
    {
        m_verticesCount = adjacencyMatrix.length;
        m_adjacencyMatrix = adjacencyMatrix;
        m_weightMatrix = new int[m_verticesCount][m_verticesCount];
        m_edges = adjacencyMatrixToEdges(adjacencyMatrix);
        m_edgesCount = m_edges.length;
    }

    Graph(int verticesCount, int edgesCount)
    {
        m_verticesCount = verticesCount;
        m_edgesCount = edgesCount;
        m_edges = new Edge[m_edgesCount];
        for (int i = 0; i < m_edgesCount; ++i)
            m_edges[i] = new Edge();
        m_weightMatrix = new int[verticesCount][verticesCount];
        m_adjacencyMatrix = new boolean[verticesCount][verticesCount];
    }

    public static Edge[] adjacencyMatrixToEdges(boolean[][] adjacencyMatrix) {
        return adjacencyMatrixToEdges(adjacencyMatrix,
                new int[adjacencyMatrix.length][adjacencyMatrix.length]);
    }

    public static Edge[] adjacencyMatrixToEdges(boolean[][] adjacencyMatrix, int[][] weightMatrix) {
        var edges = new Edge[adjacencyMatrix.length];
        for (var i = 0; i < adjacencyMatrix.length; i++) {
            for (var j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j])
                    edges[i] = (new Edge(i, j, weightMatrix[i][j]));
            }
        }
        return edges;
    }

    public static Pair<boolean[][], int[][]> edgesToAdjacencyAndWeightMatrix(
            Edge[] edges, int verticesCount) {
        var adjacencyMatrix = new boolean[verticesCount][verticesCount];
        var weightMatrix = new int[verticesCount][verticesCount];
        for (Edge edge : edges) {
            adjacencyMatrix[edge.getSource()][edge.getDestination()] = true;
            weightMatrix[edge.getSource()][edge.getDestination()] = edge.getWeight();
        }
        return new Pair<>(adjacencyMatrix, weightMatrix);
    }

    public static void setWeights(Edge[] edges, int[][] weightMatrix) {
        for (Edge edge : edges) {
            edge.setWeight(weightMatrix[edge.getSource()][edge.getDestination()]);
        }
    }

    public int getVerticesCount()
    {
        return m_verticesCount;
    }

    public int getEdgesCount()
    {
        return m_edgesCount;
    }

    public Edge[] getM_edges()
    {
        return m_edges;
    }

    public void setEdges(Edge[] edges)
    {
        m_edges = edges;
        m_edgesCount = edges.length;
        var result = edgesToAdjacencyAndWeightMatrix(edges, m_verticesCount);
        m_adjacencyMatrix = result.getKey();
        m_weightMatrix = result.getValue();
    }

    public void setWeightMatrix(int[][] weightMatrix) {
        m_weightMatrix = weightMatrix;
        setWeights(m_edges, weightMatrix);
    }

    public int[][] getWeightMatrix() { return m_weightMatrix; }

    public boolean[][] getAdjacencyMatrix() {
        return m_adjacencyMatrix;
    }

    public LinkedList<LinkedList<Integer>> getAdjacencyLists() {
        var adjacencyListsFrom = new LinkedList<LinkedList<Integer>>();
        for (var i = 0; i < m_verticesCount; i++) {
            adjacencyListsFrom.add(new LinkedList<>());
        }
        for (var i = 0; i < m_adjacencyMatrix.length; i++) {
            for (var j = 0; j < m_adjacencyMatrix.length; j++) {
                if (m_adjacencyMatrix[i][j])
                    adjacencyListsFrom.get(i).add(j);
            }
        }
        return adjacencyListsFrom;
    }
}