package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

/** Класс, предоставляющий метод поиска кратчайшего пути на графе с использованием алгоритма Дейкстры.
 */
public class DijkstraAlgorithm implements IAlgorithm {
    /** Метод находит кратчайшие расстояния от начальной вершины до всех других доступных из нчальной вершин
     * с использованием жадного метода distance. Кратчайший путь от нчальной вершины до конечной строится
     * по массиву Previous.
     * @param graph Ориентированный или неориентированный граф.
     * @param source Начальная вершина.
     * @param destination Начальная вершина.
     * @return Массив ребер, представляющий собой кратчайший путь от начальной вершины до конечной,
     * если такого нет, то возвращается null.
     */
    public ArrayList<Edge> invoke(Graph graph, int source, int destination) {
        ArrayList<Edge> r = new ArrayList<>();
        var distances = new int[graph.getVerticesCount()];
        var previous = new int[graph.getVerticesCount()];
        distance(graph, source, distances, previous);
        if (distances[destination] < Integer.MAX_VALUE) {
            var stack = new Stack<Integer>();
            stack.push(destination);
            var v = destination;
            while(previous[v] != -1) {
                v = previous[v];
                stack.push(v);
            }
            int e = stack.size();
            for (var i = 0; i < e; i++) {
                r.add(new Edge(i, stack.pop()));
            }
            for (Edge edge: r) {
                System.out.println(edge.getSource() + "   " + edge.getDestination());
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
        var F = new ArrayList<Integer>();
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            if (v == s)
                continue;
            F.add(v);
        }
        for (Integer v : F) {
            if (v == s)
                continue;
            if (adjacencyMatrix[s][v])
                distances[v] = weightMatrix[s][v];
            else {
                distances[v] = Integer.MAX_VALUE;
                continue;
            }
            previous[v] = s;
        }
        for (var k = 0; k < graph.getVerticesCount() - 1; k++) {
            var w = min(F, distances);
            F.remove((Integer) w);
            for (Integer v : F) {
                if (!adjacencyMatrix[w][v]) {
                    continue;
                }
                if (distances[w] + weightMatrix[w][v] < distances[v]) {
                    distances[v] = distances[w] + weightMatrix[w][v];
                    previous[v] = w;
                }
            }
        }
    }

    private static int min(ArrayList<Integer> F, int[] distances) {
        var minValue = Integer.MAX_VALUE;
        var min = -1;
        for (Integer w : F) {
            if (distances[w] < minValue) {
                minValue = distances[w];
                min = w;
            }
        }
        return min;
    }
}
