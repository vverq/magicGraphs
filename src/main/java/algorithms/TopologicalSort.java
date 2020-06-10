package algorithms;

import graph.Graph;

import java.util.*;

/** Класс, предоставляющий топологическую сортировку.
 */
public class TopologicalSort {
    private static void topologicalSortUtil(LinkedList<LinkedList<Integer>> adj, int v, boolean visited[], Stack stack) {
        visited[v] = true;
        Integer i;
        for (Integer integer : (Iterable<Integer>) adj.get(v)) {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(adj, i, visited, stack);
        }
        stack.push(v);
    }

    /** Метод производит топологическую сортировку ориентированного графа. Используется
     * рекрусивный подход с помощью метода topologicalSortUtil(). Модифицируем DFS.
     * В DFS мы начинаем с вершины, сначала печатаем ее, а затем вызываем DFS для
     * соседних вершин. Здесь мы используем временный стек. Мы не будем выдавать вершину
     * сразу, а вызовем топологическую сортировку для всех соседних вершин, а затем
     * положим ее в стек. Вершина помещается в стек только тогда, когда все ее соседние
     * вершины (и вершины с ними соединенные и т.д.) уже находятся в стеке.
     * @param graph Ориентированный граф.
     * @return Массив, содержащий вершины топологически отсортированного графа.
     */
    public static int[] topologicalSort(Graph graph) {
        Stack stack = new Stack();
        int v = graph.getVerticesCount();
        int[] vertices = new int[v];
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph.getAdjacencyLists(), i, visited, stack);
            }
        }
        int i = 0;
        while (!stack.empty()) {
            vertices[i] = (int)stack.pop();
            i++;
        }
        return vertices;
    }
}