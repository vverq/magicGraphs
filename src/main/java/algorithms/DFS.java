package algorithms;

import graph.Edge;
import graph.Graph;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**Класс, предоставляющий метод поиска в глубину.
 */
public class DFS {
    /** Метод поиска в ширину с использованием стека.
     * @param graph Ориентированный или неориентированный граф.
     * @param start Начальная вершина.
     * @return Массив с ребрами в порядке их нахождения.
     */
    public static ArrayList<Edge> DFS(Graph graph, int start) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        ArrayList<Edge> trace = new ArrayList<>();
        stack.push(new Pair<>(-1, start));
        HashSet<Edge> visitedEdges = new HashSet<>();
        while (!stack.empty()) {
            Pair<Integer, Integer> current_edge = stack.pop();
            if (current_edge.getKey() != -1) {
                trace.add(new Edge(current_edge.getKey(), current_edge.getValue()));
            }
            for (int target : graph.getAdjacencyLists().get(current_edge.getValue())) {
                Edge edge = new Edge(current_edge.getValue(), target);
                if (!visitedEdges.contains(edge)) {
                    visitedEdges.add(edge);
                    stack.push(new Pair<>(current_edge.getValue(), target));
                }
            }
        }
        return trace;
    }
}