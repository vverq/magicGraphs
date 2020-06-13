package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Comparator;

/** Класс, предоставляющий метод построения минимального остовного дерева
 * с помощью алгоритма Прима.
 */
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

    /** Метод строит минимальное остовного дерево по алгоритму Прима.
     * Сначала берётся произвольная вершина и находится ребро, инцидентное
     * данной вершине и обладающее наименьшей стоимостью. Найденное ребро
     * и соединяемые им две вершины образуют дерево. Затем, рассматриваются
     * рёбра графа, один конец которых — уже принадлежащая дереву вершина,
     * а другой — нет; из этих рёбер выбирается ребро наименьшей стоимости.
     * выбираемое на каждом шаге ребро присоединяется к дереву. Рост дерева
     * выбираемое на каждом шаге ребро присоединяется к дереву. Рост дерева
     * происходит до тех пор, пока не будут исчерпаны все вершины исходного графа.
     * @param graph Ориентированный или неориентированный взвешенный граф.
     * @return Массив, содержащий ребра минимального остовного дерева.
     */
    public ArrayList<Edge> primMST(Graph graph) {
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
