public class GraphColoring
{
    private boolean isCorrect(int v, int graph[][], int color[], int c)
    {
        for (int i = 0; i < graph.length; i++)
        {
            if (graph[v][i] == 1 && c == color[i])
            {
                return false;
            }
        }
        return true;
    }

    private boolean graphColoringUtil(int graph[][], int m, int color[], int v)
    {
        if (v == graph.length)
        {
            return true;
        }

        for (int c = 1; c <= m; c++)
        {
            if (isCorrect(v, graph, color, c))
            {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1))
                {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }

    private void graphColoring(Graph graph)
    {
        int V = graph.getVerticesCount();
        int[][] matrix = graph.getWeightMatrix();
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
        {
            color[i] = 0;
        }
        if (!graphColoringUtil(matrix, V, color, 0))
        {
            // TODO: кинуть варнинг ноу солюшен
            System.out.println("Нет решения");
            return;
        }
        // TODO: вывод раскраски, потом заменить нужное
        for (int i = 0; i < V; i++)
        {
            System.out.print(" " + color[i] + " ");
        }
    }

//    public static void main(String[] args)
//    {
//        int[][] adjMatrix = {
//                {0, 1, 1, 1},
//                {1, 0, 1, 0},
//                {1, 1, 0, 1},
//                {1, 0, 1, 0},
//        };
//        Graph graph = new Graph(adjMatrix);
//        new GraphColoring().graphColoring(graph);
//    }
}