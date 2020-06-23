package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

/**Класс, предоставляющий метод поиска кратчайшего пути на графе, использующий алгоритм Беллмана-Форда.
 */
public class BellmanFordAlgorithm implements IAlgorithm {

    /**С помощью метода distance, используя динамическое
     * программирование, считает кратчайшие расстояния от начальной
     * вершины до всех других вершин графа. Затем, багодаря массиву Previous,
     * собрается путь от начальной вершины до конечной, если он есть.
     * @param graph Ориентированный или неориентированный взвешенный граф.
     *              Допускаются отрицательные веса, но в графе не должно
     *              быть циклов отрицательной длины.
     * @param s Начальная вершина.
     * @param t Конечная вершина.
     * @return Массив ребер, либо null, если путь не был найден.
     */
    public ArrayList<Edge> invoke(Graph graph, int s, int t) {
        var distances = new int[graph.getVerticesCount()];
        var previous = new int[graph.getVerticesCount()];
        distance(graph, s, distances, previous);
        if (distances[t] < Integer.MAX_VALUE) {
            var stack = new Stack<Integer>();
            stack.push(t);
            var v = t;
            while(previous[v] != -1) {
                v = previous[v];
                stack.push(v);
            }
            ArrayList<Edge> r = new ArrayList<>();
            int size = stack.size();
            var vert = stack.pop();
            for (var i = 0; i < size - 1; i++) {
                var newVert = stack.pop();
                r.add(new Edge(vert, newVert));
                vert = newVert;
            }
            for (Edge e: r) {
                System.out.println(e.getSource() + "   " + e.getDestination());
            }
            return r;
        }
        else {
            return null;
        }
    }

    private static void distance(Graph graph, int s, int[] distances, int[] previous) {
        var weightMatrix = graph.getWeightMatrix();
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        previous[s] = -1;
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            if (v == s)
                continue;
            if (adjacencyMatrix[s][v])
                distances[v] = weightMatrix[s][v];
            else
                distances[v] = Integer.MAX_VALUE;
            previous[v] = s;
        }
        for (var k = 0; k < graph.getVerticesCount() - 2; k++) {
            for (var v = 0; v < graph.getVerticesCount(); v++) {
                if (v == s)
                    continue;
                for (var w = 0; w < graph.getVerticesCount(); w++) {
                    if (w == v || previous[v] == w || previous[w] == v)
                        continue;
                    if (!adjacencyMatrix[w][v])
                        continue;
                    if (distances[w] == Integer.MAX_VALUE)
                        continue;
                    if (distances[w] + weightMatrix[w][v] < distances[v]) {
                        distances[v] = distances[w] + weightMatrix[w][v];
                        previous[v] = w;
                    }
                }
            }
        }
    }
}
