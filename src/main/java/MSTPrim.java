public class MSTPrim
{
    private int minKey(int[] key, boolean[] mstSet, int V)
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++)
        {
            if (!mstSet[v] && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    private void primMST(Graph graph)
    {
        int V = graph.getVerticicesCount();
        int[][] matrix = graph.getAdjacencyMatrix();
        int[] parent = new int[V];
        parent[0] = -1;

        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;

        for (int count = 0; count < V - 1; count++)
        {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)

                if (matrix[u][v] != 0 && !mstSet[v] && matrix[u][v] < key[v])
                {
                    parent[v] = u;
                    key[v] = matrix[u][v];
                }
        }
        // TODO: Вывод получившегося минимального остовного дерева, потом заменить тело цикла на что-то нужное
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " -- " + i + " == " + matrix[i][parent[i]]);
    }

//    public static void main(String[] args)
//    {
//        int[][] adjMatrix = {
//                { 0, 2, 0, 6, 0 },
//                { 2, 0, 3, 8, 5 },
//                { 0, 3, 0, 0, 7 },
//                { 6, 8, 0, 0, 9 },
//                { 0, 5, 7, 9, 0 }
//        };
//        Graph graph = new Graph(adjMatrix);
//        new MSTPrim().primMST(graph);
//    }
}
