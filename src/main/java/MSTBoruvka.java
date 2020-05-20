public class MSTBoruvka
{
    private int find(Integer[][] subsets, int i)
    {
        if (subsets[i][0] != i)
        {
            subsets[i][0] = find(subsets, subsets[i][0]);
        }
        return subsets[i][0];
    }

    private void union(Integer[][] subsets, int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot][1] < subsets[yroot][1])
        {
            subsets[xroot][0] = yroot;
        }
        else if (subsets[xroot][1] > subsets[yroot][1])
        {
            subsets[yroot][0] = xroot;
        }
        else
        {
            subsets[yroot][0] = xroot;
            subsets[xroot][1]++;
        }
    }

    private void BoruvkaMST(Graph graph)
    {
        int V = graph.getVerticesCount();
        int numTrees = V;
        Edge[] result = new Edge[V];
        Integer[][] subsets = new Integer[V][];
        for (int i = 0; i < V; ++i)
        {
            result[i] = new Edge();
            subsets[i] = new Integer[V];
        }
        for (int v = 0; v < V; ++v)
        {
            subsets[v][0] = v;
            subsets[v][1] = 0;
        }
        while (numTrees > 1)
        {
            for (int i = 0; i < graph.getEdgesCount(); i++)
            {
                Edge next_edge = graph.getM_edges()[i];
                int w = next_edge.weight;
                int x = find(subsets, next_edge.source);
                int y = find(subsets, next_edge.destination);
                if (x != y)
                {
                    if ((result[x].source == -1 && result[x].destination == -1) || result[x].weight > w)
                    {
                        result[x] = next_edge;
                    }
                    if ((result[y].source == -1 && result[y].destination == -1) || result[y].weight > w)
                    {
                        result[y] = next_edge;
                    }
                }
            }
            for (int i = 0; i < V; i++)
            {
                if (result[i].source != -1 && result[i].destination != -1)
                {
                    Edge edge = result[i];
                    var x = find(subsets, edge.source);
                    var y = find(subsets, edge.destination);
                    if (x != y)
                    {
                        union(subsets, x, y);
                        numTrees -= 1;
                        // TODO: Вывод получившегося минимального остовного дерева, потом заменить тело цикла на что-то нужное
                        System.out.println(result[i].source + " -- " +
                                result[i].destination + " == " + result[i].weight);
                    }
                }
            }
        }
    }

//    public static void main(String[] string)
//    {
//        Graph graph = new Graph(4,5);
//        Edge[] edges = new Edge[]
//        {
//            new Edge(0, 1, 10),
//            new Edge(0, 2, 6),
//            new Edge(0, 3, 5),
//            new Edge(1, 3, 15),
//            new Edge(2, 3, 4),
//        };
//        graph.setEdges(edges);
//        new MSTBoruvka().BoruvkaMST(graph);
//    }
}
