package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/** Класс, предоставляющий метод поиска MAXMIN-пути.
 */
public class MAXMINPath implements IAlgorithm {

    /** Метод поиска MAXMIN-пути, испольующий модификацию алгоритма Дейкстры поиска кратчайшего пути.
     * @param graph Ориентированный или неориентированный граф.
     * @param s Начальная вершина.
     * @param t Конечная вершина.
     * @return Массив с MAXMIN-путем между начальной и конечной вершинами, если он есть, иначе - null.
     */
    public ArrayList<Edge> invoke(Graph graph, int s, int t) {
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
            ArrayList<Edge> r = new ArrayList<>();
            int size = stack.size();
            var vert = stack.pop();
            for (var i = 0; i < size - 1; i++) {
                var newVert = stack.pop();
                r.add(new Edge(vert, newVert));
                vert = newVert;
            }
            for (Edge e: r) {
                System.out.println(e.getSource() + "   " + e.getDestination());
            }
            return r;
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
        var S = new ArrayList<Integer>();
        S.add(s);
        distances[s] = Integer.MAX_VALUE;
        for (var k = 0; k < graph.getVerticesCount() - 1; k++) {
            for (Integer w : F) {
                distances[w] = 0;
                for (Integer v : S) {
                    if (!adjacencyMatrix[v][w])
                        continue;
                    var value = Math.min(distances[v], weightMatrix[v][w]);
                    if (value > distances[w]) {
                        distances[w] = value;
                        previous[w] = v;
                    }
                }
            }
            var maxW = 0;
            var maxWValue = -1;
            for (Integer w : F) {
                if (distances[w] > maxWValue) {
                    maxW = w;
                    maxWValue = distances[w];
                }
            }
            F.remove((Integer)maxW);
            S.add(maxW);
        }
    }
}
