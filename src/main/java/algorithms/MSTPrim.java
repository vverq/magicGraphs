package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Comparator;

public class MSTPrim {
    private int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    private ArrayList<Edge> primMST(Graph graph) {
        ArrayList<Edge> mst = new ArrayList<>();
        int V = graph.getVerticesCount();
        int[][] matrix = graph.getWeightMatrix();
        int[] parent = new int[V];
        parent[0] = -1;
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (matrix[u][v] != 0 && !mstSet[v] && matrix[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = matrix[u][v];
                }
            }
        }
        for (int i = 1; i < V; i++) {
            mst.add(new Edge(parent[i], i, matrix[i][parent[i]]));
        }
        return mst;
    }
}
