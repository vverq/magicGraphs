package algorithms;


import graph.Graph;
import graph.Edge;

import java.util.ArrayList;
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
        Stack<Integer> stack = new Stack<>();
        ArrayList<graph.Edge> DFSEdges = new ArrayList<>();
        stack.push(start);
        int count = graph.getVerticesCount();
        int[] previous = new int[count];
        boolean[] markers = new boolean[count];
        for (int i = 0; i < count; i++) {
            markers[i] = true;
            previous[i] = -1;
        }
        while (!stack.empty()) {
            int v = stack.pop();
            if (previous[v] != -1) {
                DFSEdges.add(new Edge(previous[v], v));
            }
            if (markers[v]) {
                for (int i = 0; i < graph.getAdjacencyLists().get(v).size(); ++i) {
                    stack.push(graph.getAdjacencyLists().get(v).get(i));
                    previous[graph.getAdjacencyLists().get(v).get(i)] = v;
                }
                markers[v] = false;
            }
        }
        return DFSEdges;
    }
}