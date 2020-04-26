import java.util.Arrays;

public class MSTKruskal
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

    private void KruskalMST(Graph graph)
    {
        int V = graph.getVerticicesCount();
        Edge[] result = new Edge[V];
        int i = 0;
        int j = 0;
        for (i = 0; i < V; ++i)
        {
            result[i] = new Edge();
        }
        Arrays.sort(graph.getM_edges());
        Integer[][] subsets = new Integer[V][];

        for (i = 0; i < V; ++i)
        {
            subsets[i] = new Integer[V];
        }
        for (int v = 0; v < V; ++v)
        {
            subsets[v][0] = v;
            subsets[v][1] = 0;
        }

        i = 0;
        while (j < V - 1)
        {
            Edge next_edge = graph.getM_edges()[i++];
            int x = find(subsets, next_edge.source);
            int y = find(subsets, next_edge.destination);
            if (x != y)
            {
                result[j++] = next_edge;
                union(subsets, x, y);
            }
        }

        // TODO: Вывод получившегося минимального остовного дерева, потом заменить тело цикла на что-то нужное
        for (i = 0; i < j; ++i)
            System.out.println(result[i].source + " -- " +
                    result[i].destination + " == " + result[i].weight);
    }

//    public static void main(String[] args)
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
//        new MSTKruskal().KruskalMST(graph);
//    }
}
