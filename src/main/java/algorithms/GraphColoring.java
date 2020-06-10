package algorithms;

import graph.Graph;

/** Класс, предоставляющий метод раскраски графа
 */
public class GraphColoring {
    private boolean isCorrect(int v, boolean graph[][], int color[], int c) {
        for (int i = 0; i < graph.length; i++){
            if (graph[v][i] && c == color[i]){
                return false;
            }
        }
        return true;
    }

    private boolean graphColoringUtil(boolean graph[][], int m, int color[], int v) {
        if (v == graph.length) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isCorrect(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }

    /** Метод находит раскраску графа с помощью рекурсивного подхода и использоавния метода
     * graphColoringUtil(). Цвета присваиваются разным вершинам, начиная с нулевой, один за
     * другим. При присвоении очередного цвета проверяется, имеют ли соседние вершины один и
     * тот же цвет или нет. Если есть какой-то назначенный цвет, не нарушающий условие, то
     * добавляем его в решение.
     * @param graph Ориентированный или неориентированный граф.
     * @return Массив цветов, соответствующий раскраске графа, если раскраска не существует,
     * то на консоль выводится "No solution".
     */
    public int[] graphColoring(Graph graph){
        int V = graph.getVerticesCount();
        boolean[][] matrix = graph.getAdjacencyMatrix();
        int[] color = new int[V];
        for (int i = 0; i < V; i++){
            color[i] = 0;
        }
        if (!graphColoringUtil(matrix, V, color, 0)){
            System.out.println("No solution");
        }
        return color;
    }
}