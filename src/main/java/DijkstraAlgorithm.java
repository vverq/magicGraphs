import java.util.ArrayList;
import java.util.Stack;

public class DijkstraAlgorithm {
    public static Stack<Integer> getShortestPath(Graph graph, int s, int t) {
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
            return stack;
        }
        else {
            return null;
        }
    }

    private static void distance(Graph graph, int s, int[] distances, int[] previous) {
        var weightMatrix = graph.getWeightMatrix();
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        previous[s] = -1;
        var F = new ArrayList<Integer>();
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            if (v == s)
                continue;
            F.add(v);
        }
        for (Integer v : F) {
            if (v == s)
                continue;
            if (adjacencyMatrix[s][v])
                distances[v] = weightMatrix[s][v];
            else {
                distances[v] = Integer.MAX_VALUE;
                continue;
            }
            previous[v] = s;
        }
        for (var k = 0; k < graph.getVerticesCount() - 1; k++) {
            var w = min(F, distances);
            F.remove(w);
            for (Integer v : F) {
                if (!adjacencyMatrix[w][v]) {
                    continue;
                }
                if (distances[w] + weightMatrix[w][v] < distances[v]) {
                    distances[v] = distances[w] + weightMatrix[w][v];
                    previous[v] = w;
                }
            }
        }
    }

    private static int min(ArrayList<Integer> F, int[] distances) {
        var minValue = Integer.MAX_VALUE;
        var min = -1;
        for (Integer w : F) {
            if (distances[w] < minValue) {
                minValue = distances[w];
                min = w;
            }
        }
        return min;
    }
}
