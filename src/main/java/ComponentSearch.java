import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ComponentSearch
{
    private ArrayList<ArrayList> components = new ArrayList<>();
    public ArrayList<ArrayList> componentSearch(Graph graph)
    {
        boolean[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        int verticesCount = graph.getVerticesCount();
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
                if (adjacencyMatrix[currentVertex][vertex])
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

    public static void main(String[] args)
    {
        boolean[][] matrix = new boolean[2][2];
        for (boolean[] booleans : matrix)
        {
            Arrays.fill(booleans, false);
        }
        var graph1 = new Graph(null, matrix);
        var c = new ComponentSearch();
        System.out.println(c.componentSearch(graph1));
    }

}
