package algorithms;

import graph.Graph;

import java.util.*;


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