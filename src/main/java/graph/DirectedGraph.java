package graph;

import java.util.LinkedList;

/**Класс ориентированного графа.
 */
public class DirectedGraph extends Graph {

    /** Переопределяет конструктор родительского класса.
     * @param adjacencyMatrix Матрица смежности.
     * @see graph.Graph
     */
    public DirectedGraph(boolean[][] adjacencyMatrix) {
        super(adjacencyMatrix);
    }

    /** Переопределяет конструктор родительского класса.
     * @param verticesCount Число вершин.
     * @param edgesCount Число дуг.
     * @see graph.Graph
     */
    public DirectedGraph(int verticesCount, int edgesCount)
    {
        super(verticesCount, edgesCount);
    }

    /** Метод по матрице смежности формирует списки смежности ИЗ.
     * @return Списки смежности, в которых по номеру вершины можно получить список вершин,
     * из которых в графе есть ребро в данную вершину.
     */
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

    /** Метод, переопределяющий родительский метод getAdjacencyLists().
     * @return Списки смежности, в которых по номеру вершины можно получить список вершин,
     * в которыу в графе есть ребро из данной вершины.
     */
    public LinkedList<LinkedList<Integer>> getAdjacencyListsTo() {
        return getAdjacencyLists();
    }
}
