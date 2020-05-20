import java.util.LinkedList;
import java.util.Stack;

public class EulerianPath {
    public static boolean isGraphEulerian(Graph graph) {
        var compSearch = new ComponentSearch();
        if (graph.getVerticesCount() == 1 || compSearch.componentSearch(graph).size() > 1) {
            return false;
        }
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            if (graph.getAdjacencyList()[v].size() % 2 == 1)
                return false;
        }
        return true;
    }

    public static Stack<Integer> getEulerianPath(Graph graph, int start) {
        var sWork = new Stack<Integer>();
        var sRes = new Stack<Integer>();
        sWork.push(start);
        LinkedList<Integer>[] listW = new LinkedList[graph.getVerticesCount()];
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            listW[v] = (LinkedList<Integer>) graph.getAdjacencyList()[v].clone();
        }
        while (!sWork.isEmpty()) {
            var v = sWork.get(sWork.size() - 1);
            if (!listW[v].isEmpty()) {
                var u = listW[v].get(0);
                sWork.push(u);
                listW[v].remove(u);
                listW[u].remove(v);
            }
            else {
                sWork.pop();
                sRes.push(v);
            }
        }
        return sRes;
    }
}
