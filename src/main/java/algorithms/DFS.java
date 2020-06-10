package algorithms;

import graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

/**Класс, предоставляющий метод поиска в глубину.
 */
public class DFS {
    /** Метод поиска в ширину с использованием стека.
     * @param graph Ориентированный или неориентированный граф.
     * @param start Начальная вершина.
     * @return Массив с вершинами в порядке их нахождения.
     */
    public static ArrayList<Integer> DFS(Graph graph, int start) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> DFSVertices = new ArrayList<>();
        stack.push(start);
        DFSVertices.add(start);
        int count = graph.getVerticesCount();
        boolean[] markers = new boolean[count];
        for (int i = 0; i < count; i++) {
            markers[i] = true;
        }
        while (!stack.empty()) {
            int v = stack.pop();
            if (!DFSVertices.contains(v)) {
                DFSVertices.add(v);
            }
            for (int i = 0; i < graph.getAdjacencyLists().get(v).size(); ++i) {
                if (markers[graph.getAdjacencyLists().get(v).get(i)]) {
                    stack.push(graph.getAdjacencyLists().get(v).get(i));
                    markers[graph.getAdjacencyLists().get(v).get(i)] = false;
                }
            }
        }
        return DFSVertices;
    }
}