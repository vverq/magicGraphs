package tests.ShortestPathInTopologicalSortedGraph;
import algorithms.MAXMINPath;
import algorithms.ShortestPathInTopologicalSortedGraph;
import org.junit.*;
import tests.Reader;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ShortestPathInTopologicalSortedGraphTests {
    private boolean[][] adjacencyMatrix1;
    private int[][] weightMatrix1;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/BellmanFordAlgorithm/in.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        weightMatrix1 = (int[][])result.get(1);
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        var expected = new int[3];
        expected[0] = 0;
        expected[1] = 2;
        expected[2] = 4;
        var sortedVertices = new int[5];
        sortedVertices[0] = 0;
        sortedVertices[1] = 1;
        sortedVertices[2] = 2;
        sortedVertices[3] = 3;
        sortedVertices[4] = 4;
        assertArrayEquals(expected, ShortestPathInTopologicalSortedGraph.getShortestPath(graph, 0,
                4, sortedVertices));
    }
}
