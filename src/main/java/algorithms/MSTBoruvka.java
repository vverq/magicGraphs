package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;

/** Класс, предоставляющий метод построения минимального остовного дерева
 * с помощью алгоритма Борувки.
 */
public class MSTBoruvka {
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

    /** Метод строит минимальное остовного дерево по алгоритму Борувки.
     * Изначально каждая вершина графа представляет собой тривиальное
     * дерево, а ребра изначально не принадлежат никакому дереву.
     * Для каждого дерева находим минимальное инцидентное ему ребро.
     * Добавим все такие ребра. Повторяется это операция до тех пор,
     * пока не останется только одно дерево.
     * @param graph Ориентированный или неориентированный взвешенный граф.
     * @return Массив, содержащий ребра минимального остовного дерева.
     */
    public ArrayList<Edge> BoruvkaMST(Graph graph) {
        int V = graph.getVerticesCount();
        int numTrees = V;
        ArrayList<Edge> mst = new ArrayList<>();
        Edge[] result = new Edge[V];
        Integer[][] subsets = new Integer[V][];
        for (int i = 0; i < V; ++i) {
            result[i] = new Edge();
            subsets[i] = new Integer[V];
        }
        for (int v = 0; v < V; ++v) {
            subsets[v][0] = v;
            subsets[v][1] = 0;
        }
        while (numTrees > 1) {
            for (int i = 0; i < graph.getEdgesCount(); i++) {
                Edge next_edge = graph.getM_edges()[i];
                int w = next_edge.getWeight();
                int x = find(subsets, next_edge.getSource());
                int y = find(subsets, next_edge.getDestination());
                if (x != y) {
                    if ((result[x].getSource() == -1 && result[x].getDestination() == -1) || result[x].getWeight() > w) {
                        result[x] = next_edge;
                    }
                    if ((result[y].getSource() == -1 && result[y].getDestination() == -1) || result[y].getWeight() > w) {
                        result[y] = next_edge;
                    }
                }
            }
            for (int i = 0; i < V; i++) {
                if (result[i].getSource() != -1 && result[i].getDestination() != -1) {
                    Edge edge = result[i];
                    var x = find(subsets, edge.getSource());
                    var y = find(subsets, edge.getDestination());
                    if (x != y) {
                        union(subsets, x, y);
                        numTrees -= 1;
                        mst.add(edge);
                    }
                }
            }
        }
        return mst;
    }
}
