package algorithms;

import graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
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
        System.out.println(DFSVertices);
        return DFSVertices;
    }
}