public class HamiltonianCycle
{
    private boolean isCorrect(int v, int graph[][], int cycle[], int current)
    {
        if (graph[cycle[current - 1]][v] == 0)
        {
            return false;
        }
        for (int i = 0; i < current; i++)
        {
            if (cycle[i] == v)
            {
                return false;
            }
        }
        return true;
    }

    private boolean hamiltonianCycleUtil(int[][] matrix, int[] cycle, int current, int V)
    {
        if (current == V)
        {
            return matrix[cycle[current - 1]][cycle[0]] == 1;
        }

        for (int v = 1; v < V; v++)
        {
            if (isCorrect(v, matrix, cycle, current))
            {
                cycle[current] = v;
                if (hamiltonianCycleUtil(matrix, cycle, current + 1, V))
                {
                    return true;
                }
                cycle[current] = -1;
            }
        }
        return false;
    }

    private void hamiltonianCycle(Graph graph)
    {
        int[][] matrix = graph.getWeightMatrix();
        int V = graph.getVerticesCount();
        int[] cycle = new int[V];
        for (int i = 0; i < V; i++)
        {
            cycle[i] = -1;
        }
        cycle[0] = 0;
        if (!hamiltonianCycleUtil(matrix, cycle, 1, V))
        {
            // TODO: выкинуть варнинг, что решения нет
            System.out.println("\nНет решения");
            return;
        }

        // TODO: вывод получившегося цикла, потом заменить нужное
        for (int i = 0; i < V; i++)
        {
            System.out.print("- " + cycle[i] + " -");
        }
        System.out.println("- " + cycle[0] + " -");
    }

//    public static void main(String args[])
//    {
//        int[][] adjMatrix = {
//                {0, 1, 0, 1, 0},
//                {1, 0, 1, 1, 1},
//                {0, 1, 0, 0, 1},
//                {1, 1, 0, 0, 1},
//                {0, 1, 1, 1, 0},
//        };
//        Graph graph = new Graph(adjMatrix);
//        new HamiltonianCycle().hamiltonianCycle(graph);
//    }
}
