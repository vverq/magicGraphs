package graph;

import graph.Graph;

/** Класс неориентированного графа.
 */
public class UndirectedGraph extends Graph {

    /** Переопределяет конструктор родительского класса.
     * @param adjacencyMatrix Матрица смежности.
     * @see graph.Graph
     */
    public UndirectedGraph(boolean[][] adjacencyMatrix) {
        super(adjacencyMatrix);
    }

    /** Переопределяет конструктор родительского класса.
     * @param verticesCount Число вершин.
     * @param edgesCount Число дуг.
     * @see graph.Graph
     */
    public UndirectedGraph(int verticesCount, int edgesCount) {
        super(verticesCount, edgesCount);
    }
}
