package algorithms;

import graph.Edge;
import graph.Graph;

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
                int w = next_edge.getWeight();
                int x = find(subsets, next_edge.getSource());
                int y = find(subsets, next_edge.getDestination());
                if (x != y)
                {
                    if ((result[x].getSource() == -1 && result[x].getDestination() == -1) || result[x].getWeight() > w)
                    {
                        result[x] = next_edge;
                    }
                    if ((result[y].getSource() == -1 && result[y].getDestination() == -1) || result[y].getWeight() > w)
                    {
                        result[y] = next_edge;
                    }
                }
            }
            for (int i = 0; i < V; i++)
            {
                if (result[i].getSource() != -1 && result[i].getDestination() != -1)
                {
                    Edge edge = result[i];
                    var x = find(subsets, edge.getSource());
                    var y = find(subsets, edge.getDestination());
                    if (x != y)
                    {
                        union(subsets, x, y);
                        numTrees -= 1;
                        // TODO: Вывод получившегося минимального остовного дерева, потом заменить тело цикла на что-то нужное
                        System.out.println(result[i].getSource() + " -- " +
                                result[i].getDestination() + " == " + result[i].getWeight());
                    }
                }
            }
        }
    }

//    public static void main(String[] string)
//    {
//        graph.Graph graph = new graph.Graph(4,5);
//        graph.Edge[] edges = new graph.Edge[]
//        {
//            new graph.Edge(0, 1, 10),
//            new graph.Edge(0, 2, 6),
//            new graph.Edge(0, 3, 5),
//            new graph.Edge(1, 3, 15),
//            new graph.Edge(2, 3, 4),
//        };
//        graph.setEdges(edges);
//        new algorithms.MSTBoruvka().BoruvkaMST(graph);
//    }
}
