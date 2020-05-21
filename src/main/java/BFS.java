import java.util.ArrayDeque;

public class BFS {
    public static int[] BFS(Graph graph, int start) {
        var i = 0;
        var num = new int[graph.getVerticesCount()];
        var father = new int[graph.getVerticesCount()];
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            father[v] = 0;
            var Q = new ArrayDeque<Integer>();
            Q.addLast(v);
            num[v] = i;
            i++;
            while (!Q.isEmpty()) {
                var u = Q.pollFirst();
                for (Integer w : graph.getAdjacencyLists().get(u)) {
                    if (num[w] == 0) {
                        Q.addLast(w);
                        father[w] = u;
                        num[w] = i;
                        i++;
                    }
                }
            }
        }
        return num;
    }
}
