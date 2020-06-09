package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MSTKruskal {
    private int find(Integer[][] subsets, int i) {
        if (subsets[i][0] != i) {
            subsets[i][0] = find(subsets, subsets[i][0]);
        }
        return subsets[i][0];
    }

    private void union(Integer[][] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot][1] < subsets[yroot][1]) {
            subsets[xroot][0] = yroot;
        }
        else if (subsets[xroot][1] > subsets[yroot][1]) {
            subsets[yroot][0] = xroot;
        }
        else {
            subsets[yroot][0] = xroot;
            subsets[xroot][1]++;
        }
    }

    public ArrayList<Edge> KruskalMST(Graph graph) {
        ArrayList<Edge> mst = new ArrayList<>();
        int V = graph.getVerticesCount();
        Edge[] result = new Edge[V];
        int i = 0;
        int j = 0;
        for (i = 0; i < V; ++i) {
            result[i] = new Edge();
        }
        Arrays.sort(graph.getM_edges());
        Integer[][] subsets = new Integer[V][];
        for (i = 0; i < V; ++i) {
            subsets[i] = new Integer[V];
        }
        for (int v = 0; v < V; ++v) {
            subsets[v][0] = v;
            subsets[v][1] = 0;
        }
        i = 0;
        while (j < V - 1) {
            Edge next_edge = graph.getM_edges()[i++];
            int x = find(subsets, next_edge.getSource());
            int y = find(subsets, next_edge.getDestination());
            if (x != y) {
                result[j++] = next_edge;
                union(subsets, x, y);
            }
        }
        for (i = 0; i < j; ++i) {
            mst.add(result[i]);
            mst.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge edge1, Edge edge2) {
                    return edge1.getSource() - edge2.getSource();
                }
            });
        }
        return mst;
    }
}
