import java.util.*;
class TopologicalSort
{
    private LinkedList<Integer> adj[];
    void addEdge(int v,int w) { adj[v].add(w); } //need refactoring

    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
    {
        visited[v] = true;
        Integer i;
        for (Integer integer : adj[v]) {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(v);
    }

    void topologicalSort(Graph graph)
    {
        var v = graph.getVertecicesCount();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;
        for (int i = 0; i < v; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }


//    public static void main(String args[])
//    {
//        g.topologicalSort();
//    }
}