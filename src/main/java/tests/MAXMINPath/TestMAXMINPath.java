package tests.MAXMINPath;
import algorithms.MAXMINPath;
import org.junit.*;
import tests.Reader;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestMAXMINPath {
    private boolean[][] adjacencyMatrix1;
    private int[][] weightMatrix1;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/BellmanFordAlgorithm/in1.txt"));
        adjacencyMatrix1 = result.getKey();
        weightMatrix1 = result.getValue();
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        var expected = new int[3];
        expected[0] = 0;
        expected[1] = 2;
        expected[2] = 4;
        assertArrayEquals(expected, MAXMINPath.getMAXMINPath(graph, 0, 4));
    }
}
