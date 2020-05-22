package tests.BellmanFordAlgorithm;

import algorithms.BellmanFordAlgorithm;
import org.junit.*;
import tests.Reader;

import java.io.File;

import static org.junit.Assert.*;


public class TestBellmanFordAlgorithm{

    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;
    private int[][] weightMatrix1;
    private int[][] weightMatrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/BellmanFordAlgorithm/in1.txt"));
        adjacencyMatrix1 = result.getKey();
        weightMatrix1 = result.getValue();
        result = reader.readFile(new File("./src/main/java/tests/BellmanFordAlgorithm/in1.txt"));
        adjacencyMatrix2 = result.getKey();
        weightMatrix2 = result.getValue();
    }

    @Test
    public void whenGraphWithPositiveWeights(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        var expected = new int[3];
        expected[0] = 0;
        expected[1] = 2;
        expected[2] = 4;
        assertArrayEquals(expected, BellmanFordAlgorithm.getShortestPath(graph, 0, 4));
    }

    @Test
    public void whenGraphWithNegativeWeights(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix2);
        graph.setWeightMatrix(weightMatrix2);
        var expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 3;
        expected[3] = 4;
        assertArrayEquals(expected, BellmanFordAlgorithm.getShortestPath(graph, 0, 4));
    }
}

