package algorithms;

import algorithms.ComponentSearch;
import graph.Graph;
import graph.UndirectedGraph;

import java.util.LinkedList;
import java.util.Stack;

/** Класс, предоставляющий методы проверки графа на то, является ли он
 * эйлеровым, и метод поиска эйлеровой цепи в графе.
 */
public class EulerianPath {
    /** Метод проверки графа на то, является ли он эйлеровым.
     * @param graph Неориентированный граф.
     * @return true - если граф эйлеров, иначе - false.
     */
    public static boolean isGraphEulerian(UndirectedGraph graph) {
        var compSearch = new ComponentSearch();
        if (graph.getVerticesCount() == 1 || compSearch.componentSearch(graph).size() > 1) {
            return false;
        }
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            if (graph.getAdjacencyLists().get(v).size() % 2 == 1)
                return false;
        }
        return true;
    }

    /** Метод поиска эйлеровой цепи в графе.
     * @param graph Неориентированный граф.
     * @param start Начальная вершина.
     * @return Стек с вершинами в цепи.
     */
    public static Stack<Integer> getEulerianPath(UndirectedGraph graph, int start) {
        var sWork = new Stack<Integer>();
        var sRes = new Stack<Integer>();
        sWork.push(start);
        LinkedList<Integer>[] listW = new LinkedList[graph.getVerticesCount()];
        for (var v = 0; v < graph.getVerticesCount(); v++) {
            listW[v] = (LinkedList<Integer>) graph.getAdjacencyLists().get(v).clone();
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
