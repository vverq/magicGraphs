package algorithms;

import graph.Graph;

import java.util.ArrayDeque;

/**Класс, предоставляющий метод поиска в ширину.
 */
public class BFS {
    /** Метод поиска в ширину с использованием очереди.
     * @param graph Ориентированный или неориентированный граф.
     * @param start Начальная вершина.
     * @return Массив с вершинами в порядке их нахождения.
     */
    public static int[] BFS(Graph graph, int start) {
        var i = 0;
        var num = new int[graph.getVerticesCount()];
        for (var j = 0; j < graph.getVerticesCount(); j++) {
            num[j] = -1;
        }
        var adjacencyLists = graph.getAdjacencyLists();
        var Q = new ArrayDeque<Integer>();
        Q.addLast(start);
        while (!Q.isEmpty()) {
            var v = Q.pop();
            num[v] = i;
            i++;
            for (Integer w : adjacencyLists.get(v)) {
                if (!Q.contains(w) && num[w] == -1)
                    Q.addLast(w);
            }
        }
        return num;
    }
}