import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ComponentSearch
{
    private ArrayList<ArrayList> components = new ArrayList<>();
    public ArrayList<ArrayList> componentSearch(Graph graph)
    {
        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        int verticesCount = graph.getVerticicesCount();
        HashSet<Integer> unvisitedVertices = new HashSet<>();
        for (int i = 0; i < verticesCount; i++)
        {
            unvisitedVertices.add(i);
        }
        HashSet<Integer> verticesToVisit = new HashSet<>();
        while (true)
        {
            ArrayList<Integer> vertexComponent = new ArrayList<>();
            int vertex = 0;
            if (unvisitedVertices.isEmpty())
            {
                break;
            }
            int currentVertex = Collections.min(unvisitedVertices);
            vertexComponent.add(currentVertex);
            unvisitedVertices.remove(currentVertex);
            while (vertex < verticesCount)
            {
                if (adjacencyMatrix[currentVertex][vertex] == 1)
                {
                    if (unvisitedVertices.contains(vertex))
                    {
                        verticesToVisit.add(vertex);
                        vertexComponent.add(currentVertex);
                    }
                }
                vertex += 1;
            }
            components.add(vertexComponent);
        }
        return components;
    }

//    public static void main(String[] args)
//    {
//        Integer[][] matrix = new Integer[2][2];
//        for (Integer[] integers : matrix)
//        {
//            Arrays.fill(integers, 0);
//        }
//        var graph1 = new Graph(null, matrix);
//        var c = new ComponentSearch();
//        System.out.println(c.componentSearch(graph1));
//    }
}
