package algorithms;

import graph.Graph;

/** Класс, предоставляющий метод поиска Гамильтонова цикла.
 */
public class HamiltonianCycle {
    private boolean isCorrect(int v, boolean graph[][], int cycle[], int current) {
        if (!graph[cycle[current - 1]][v]) {
            return false;
        }
        for (int i = 0; i < current; i++) {
            if (cycle[i] == v) {
                return false;
            }
        }
        return true;
    }

    private boolean hamiltonianCycleUtil(boolean[][] matrix, int[] cycle, int current, int V) {
        if (current == V) {
            return matrix[cycle[current - 1]][cycle[0]];
        }
        for (int v = 1; v < V; v++) {
            if (isCorrect(v, matrix, cycle, current)) {
                cycle[current] = v;
                if (hamiltonianCycleUtil(matrix, cycle, current + 1, V)) {
                    return true;
                }
                cycle[current] = -1;
            }
        }
        return false;
    }

    /** Метод находит Гамильтонов цикл в графе. Используется рекрусивный подход с помощью
     * метода hamiltonianCycleUtil(). В начале создается пустой массив и к нему добавляется
     * лишь нулевая вершина. Затем добавляются другие вершины, начиная с первой. После
     * добавления очередной вершины проверяется, соседствует ли она с ранее добавленной вершиной
     * и не добавлена ли она уже. Если такая находится, то добавляем ее в решение.
     * @param graph Ориентированный или неориентированный граф.
     * @return Массив, содержащий вершины, образующие Гамильтонов цикл. Если такой цикл
     * не найден, то на консоль выводится "No Solution" и возвращается пустой массив.
     */
    public int[] hamiltonianCycle(Graph graph) {
        boolean[][] matrix = graph.getAdjacencyMatrix();
        int V = graph.getVerticesCount();
        int[] cycle = new int[V+1];
        for (int i = 0; i <= V; i++) {
            cycle[i] = -1;
        }
        cycle[0] = 0;
        if (!hamiltonianCycleUtil(matrix, cycle, 1, V)) {
            System.out.println("\nNo Solution");
            return new int[V+1];
        }
        cycle[cycle.length - 1] = cycle[0];
        return cycle;
    }
}
