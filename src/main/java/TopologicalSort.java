import java.util.*;


class TopologicalSort
{
    private static void topologicalSortUtil(LinkedList[] adj, int v, boolean visited[], Stack stack)
    {
        visited[v] = true;
        Integer i;
        for (Integer integer : (Iterable<Integer>) adj[v])
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
                topologicalSortUtil(graph.getAdjacencyList(), i, visited, stack);
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
//        LinkedList[] adj = new LinkedList[6];
//        for (int i=0; i<=5; ++i)
//            adj[i] = new LinkedList();
//        adj[5].add(2);
//        adj[5].add(0);
//        adj[4].add(0);
//        adj[4].add(1);
//        adj[2].add(3);
//        adj[3].add(1);
//
//        Graph g = new Graph(6, adj, null);
//        TopologicalSort.topologicalSort(g);
//    }
}