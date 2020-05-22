package algorithms;

import graph.Graph;

import java.util.Arrays;
import java.util.Stack;

public class BellmanFordAlgorithm {
    public static int[] getShortestPath(Graph graph, int s, int t) {
        var distances = new int[graph.getVerticesCount()];
        var previous = new int[graph.getVerticesCount()];
        distance(graph, s, distances, previous);
        if (distances[t] < Integer.MAX_VALUE) {
            var stack = new Stack<Integer>();
            stack.push(t);
            var v = t;
            while(previous[v] != -1) {
                v = previous[v];
                stack.push(v);
            }
            var result = new int[stack.size()];
            for (var i = 0; i < result.length; i++) {
                result[i] = stack.pop();
            }
            return result;
        }
        else {
            return null;
        }
    }

    private static void distance(Graph graph, int s, int[] distances, int[] previous) {
        var weightMatrix = graph.getWeightMatrix();
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        previous[s] = -1;
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            if (v == s)
                continue;
            if (adjacencyMatrix[s][v])
                distances[v] = weightMatrix[s][v];
            else
                distances[v] = Integer.MAX_VALUE;
            previous[v] = s;
        }
        for (var k = 0; k < graph.getVerticesCount() - 2; k++) {
            for (var v = 0; v < graph.getVerticesCount(); v++) {
                if (v == s)
                    continue;
                for (var w = 0; w < graph.getVerticesCount(); w++) {
                    if (w == v || previous[v] == w || previous[w] == v)
                        continue;
                    if (!adjacencyMatrix[w][v])
                        continue;
                    if (distances[w] == Integer.MAX_VALUE)
                        continue;
                    if (distances[w] + weightMatrix[w][v] < distances[v]) {
                        distances[v] = distances[w] + weightMatrix[w][v];
                        previous[v] = w;
                    }
                }
            }
        }
    }
}
