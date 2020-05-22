package algorithms;

import graph.Graph;

import java.util.*;


class TopologicalSort
{
    private static void topologicalSortUtil(LinkedList<LinkedList<Integer>> adj, int v, boolean visited[], Stack stack)
    {
        visited[v] = true;
        Integer i;
        for (Integer integer : (Iterable<Integer>) adj.get(v))
        {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(adj, i, visited, stack);
        }
        stack.push(v);
    }

    private static void topologicalSort(Graph graph)
    {
        Stack stack = new Stack();
        int v = graph.getVerticesCount();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++)
        {
            visited[i] = false;
        }
        for (int i = 0; i < v; i++)
        {
            if (!visited[i])
            {
                topologicalSortUtil(graph.getAdjacencyLists(), i, visited, stack);
            }
        }
        // TODO: Вывод результатов топологической сортировки, потом заменим тело цикла на что-то нужное
        while (!stack.empty())
        {
            System.out.print(stack.pop() + " ");
        }
    }

//    public static void main(String args[])
//    {
//        graph.Graph g = new graph.Graph(6, 6);
//        g.setEdges(new graph.Edge[]{new graph.Edge(5, 2), new graph.Edge(5, 0), new graph.Edge(4, 0), new graph.Edge(4, 1), new graph.Edge(2, 3), new graph.Edge(3,1)});
//        algorithms.TopologicalSort.topologicalSort(g);
//    }
}