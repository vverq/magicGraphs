import java.util.Stack;

public class ShortestPathInTopologicalSortedGraph {
    public static Stack<Integer> getShortestPath(Graph graph, int s, int t, int[] sortedVertices) {
        var distances = new int[graph.getVerticesCount()];
        var previous = new int[graph.getVerticesCount()];
        int[] newSortedVertices = null;
        var shift = -1;
        var flag = false;
        for (var i = 0; i < sortedVertices.length; i++) {
            if (sortedVertices[i] == s) {
                newSortedVertices = new int[sortedVertices.length - i];
                flag = true;
                shift = i;
            }
            if (flag) {
                newSortedVertices[i - shift] = sortedVertices[i];
            }
        }
        distance(graph, newSortedVertices, s, distances, previous);
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

    private static void distance(Graph graph, int[] sortedVertices, int v0, int[] distances, int[] previous) {
        var weightMatrix = graph.getWeightMatrix();
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        previous[v0] = -1;
        for (var k = 2; k <= graph.getVerticesCount(); k++) {
            distances[sortedVertices[k]] = Integer.MAX_VALUE;
        }
        for (var k = 2; k <= graph.getVerticesCount(); k++) {
            for (Integer w : graph.getAdjacencyListTo(sortedVertices[k])) {
                if (distances[w] + weightMatrix[w][sortedVertices[k]] < distances[sortedVertices[k]]) {
                    distances[sortedVertices[k]] = distances[w] + weightMatrix[w][sortedVertices[k]];
                    previous[sortedVertices[k]] = w;
                }
            }
        }
    }
}
