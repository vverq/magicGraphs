import java.util.Stack;

public class DFS
{
    private static void DFS(Graph graph, int start)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int count = graph.getVerticesCount();
        boolean[] mark = new boolean[count];
        for (int i = 0; i < count; i++)
        {
            mark[i] = true;
        }

        while (!stack.empty())
        {
            int v = stack.firstElement();
            stack.pop();
            for (int i = 0; i < graph.getAdjacencyLists().get(v).size(); ++i)
            {
                if (mark[(int) graph.getAdjacencyLists().get(v).get(i)])
                {
                    stack.push((Integer) graph.getAdjacencyLists().get(v).get(i));
                    mark[(int) graph.getAdjacencyLists().get(v).get(i)] = false;
                }
            }
        }
    }

//    public static void main(String[] args)
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
//        Graph graph = new Graph(6, adj, null);
//        System.out.println(Arrays.toString(DFS.DFS(graph, 2)));
//    }
}