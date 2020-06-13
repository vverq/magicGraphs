package graph;

import java.util.ArrayList;
import java.util.LinkedList;

/** Класс графа.
 */
public class Graph
{
    private int m_verticesCount;
    private int m_edgesCount;
    private Edge[] m_edges;
    private boolean[][] m_adjacencyMatrix;
    private int[][] m_weightMatrix;

    /** Инициализирует приватные поля m_verticesCount, m_adjacencyMatrix, m_weightMatrix,
     * m_edges, m_edgesCount.
     * @param adjacencyMatrix Матрица смежности.
     */
    public Graph(boolean[][] adjacencyMatrix)
    {
        m_verticesCount = adjacencyMatrix.length;
        m_adjacencyMatrix = adjacencyMatrix;
        m_weightMatrix = new int[m_verticesCount][m_verticesCount];
        m_edges = adjacencyMatrixToEdges(adjacencyMatrix);
        m_edgesCount = m_edges.length;
    }

    /** Инициализирует приватные поля m_verticesCount, m_adjacencyMatrix, m_weightMatrix,
     * m_edges, m_edgesCount.
     * @param verticesCount Число вершин.
     * @param edgesCount Число ребер.
     */
    public Graph(int verticesCount, int edgesCount)
    {
        m_verticesCount = verticesCount;
        m_edgesCount = edgesCount;
        m_edges = new Edge[m_edgesCount];
        for (int i = 0; i < m_edgesCount; ++i)
            m_edges[i] = new Edge();
        m_weightMatrix = new int[verticesCount][verticesCount];
        m_adjacencyMatrix = new boolean[verticesCount][verticesCount];
    }

    /** Статический метод, который получает из матрицы смежности массив ребер.
     * @param adjacencyMatrix Матрица смежности.
     * @return Массив ребер.
     */
    public static Edge[] adjacencyMatrixToEdges(boolean[][] adjacencyMatrix) {
        return adjacencyMatrixToEdges(adjacencyMatrix,
                new int[adjacencyMatrix.length][adjacencyMatrix.length]);
    }

    /** Статический метод, который получает из матрицы смежности
     * и матрицы весов массив ребер.
     * @param adjacencyMatrix Матрица смежности.
     * @param weightMatrix Матрица весов.
     * @return Массив ребер.
     */
    public static Edge[] adjacencyMatrixToEdges(boolean[][] adjacencyMatrix, int[][] weightMatrix) {
        var edges = new ArrayList<Edge>();
        for (var i = 0; i < adjacencyMatrix.length; i++) {
            for (var j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j])
                    edges.add(new Edge(i, j, weightMatrix[i][j]));
            }
        }
        var result = new Edge[edges.size()];
        for (var i = 0; i < edges.size(); i++) {
            result[i] = edges.get(i);
        }
        return result;
    }

    /** Статический метод, который получает из массива ребер получает матрицу смежности и матрицу весов.
     * @param edges Массив ребер.
     * @param verticesCount Число вершин.
     * @return Список, в котором первый элемент - это матрица смежности,
     * а второй - матрица весов.
     */
    public static ArrayList edgesToAdjacencyAndWeightMatrix(
            Edge[] edges, int verticesCount) {
        var adjacencyMatrix = new boolean[verticesCount][verticesCount];
        var weightMatrix = new int[verticesCount][verticesCount];
        for (Edge edge : edges) {
            adjacencyMatrix[edge.getSource()][edge.getDestination()] = true;
            weightMatrix[edge.getSource()][edge.getDestination()] = edge.getWeight();
        }
        var result = new ArrayList();
        result.add(adjacencyMatrix);
        result.add(weightMatrix);
        return result;
    }

    /** Статический метод, который по матрице весов устанавливает веса для ребер в массиве.
     * @param edges Массив ребер.
     * @param weightMatrix Матрица весов.
     */
    public static void setWeights(Edge[] edges, int[][] weightMatrix) {
        for (Edge edge : edges) {
            edge.setWeight(weightMatrix[edge.getSource()][edge.getDestination()]);
        }
    }

    /** Геттер приватного поля m_verticesCount.
     * @return Число вершин.
     */
    public int getVerticesCount()
    {
        return m_verticesCount;
    }

    /** Геттер приватного поля m_edgesCount.
     * @return Число ребер.
     */
    public int getEdgesCount()
    {
        return m_edgesCount;
    }

    /** Геттер приватного поля m_edges.
     * @return Массив ребер.
     */
    public Edge[] getM_edges()
    {
        return m_edges;
    }

    /** Сеттер приватного поля edges. Меняет остальные поля в соответствии с переданным массивом ребер.
     * @param edges Массив ребер.
     */
    public void setEdges(Edge[] edges)
    {
        m_edges = edges;
        m_edgesCount = edges.length;
        var result = edgesToAdjacencyAndWeightMatrix(edges, m_verticesCount);
        m_adjacencyMatrix = (boolean[][])result.get(0);
        m_weightMatrix = (int[][])result.get(1);
    }

    /** Сеттер приватного поля weightMatrix. Меняет остальные поля в соответствии
     * с переданной матрицей весов.
     * @param weightMatrix Матрица весов.
     */
    public void setWeightMatrix(int[][] weightMatrix) {
        m_weightMatrix = weightMatrix;
        setWeights(m_edges, weightMatrix);
    }

    /** Геттер приватного поля m_weightMatrix.
     * @return Матрица весов.
     */
    public int[][] getWeightMatrix() { return m_weightMatrix; }

    /** Геттер приватного поля m_adjacencyMatrix.
     * @return Матрица смежности.
     */
    public boolean[][] getAdjacencyMatrix() {
        return m_adjacencyMatrix;
    }

    /** Метод, который из матрицы смежности получает списки смежности В.
     * @return Списки смежности, в которых по номеру вершины можно получить список вершин,
     * в которые в графе есть ребро из данной вершины.
     */
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