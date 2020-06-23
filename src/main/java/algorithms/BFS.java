package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

/**Класс, предоставляющий метод поиска в ширину.
 */
public class BFS implements IAlgorithm {
    /** Метод поиска в ширину с использованием очереди.
     * @param graph Ориентированный или неориентированный граф.
     * @param start Начальная вершина.
     * @return Массив с ребрами в порядке их нахождения.
     */
    public ArrayList<Edge> invoke(Graph graph, int start, int finish) {
        var i = 0;
        ArrayList<Edge> trace = new ArrayList<>();
        var Q = new ArrayDeque<Edge>();
        HashSet<Edge> visitedEdges = new HashSet<>();
        Q.addLast(new Edge(-1, start));
        while (!Q.isEmpty()) {
            var v = Q.pop();
            if (v.getSource() != -1) {
                trace.add(v);
            }
            i++;
            for (int target : graph.getAdjacencyLists().get(v.getDestination())) {
                Edge edge = new Edge(v.getDestination(), target);
                if (!visitedEdges.contains(edge)) {
                    visitedEdges.add(edge);
                    Q.addLast(edge);
                }
            }
        }
        return trace;
    }
}