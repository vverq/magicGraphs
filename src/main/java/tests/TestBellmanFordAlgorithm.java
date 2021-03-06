package tests;

import algorithms.BellmanFordAlgorithm;
import graph.Edge;
import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestBellmanFordAlgorithm{

    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;
    private int[][] weightMatrix1;
    private int[][] weightMatrix2;
    private BellmanFordAlgorithm bellmanFordAlgorithm;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/BellmanFord1.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        weightMatrix1 = (int[][])result.get(1);
        result = reader.readFile(new File("./src/main/resources/BellmanFord2.txt"));
        adjacencyMatrix2 = (boolean[][])result.get(0);
        weightMatrix2 = (int[][])result.get(1);
        bellmanFordAlgorithm = new BellmanFordAlgorithm();
    }

    @Test
    public void whenGraphWithPositiveWeights(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        var expected = new Edge[2];
        expected[0] = new Edge(0, 2);
        expected[1] = new Edge(2, 4);
        assertArrayEquals(expected, bellmanFordAlgorithm.invoke(graph, 0, 4).toArray());
    }

    @Test
    public void whenGraphWithNegativeWeights(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix2);
        graph.setWeightMatrix(weightMatrix2);
        var expected = new Edge[3];
        expected[0] = new Edge(0, 1);
        expected[1] = new Edge(1, 3);
        expected[2] = new Edge(3, 4);
        assertArrayEquals(expected, bellmanFordAlgorithm.invoke(graph, 0, 4).toArray());
    }
}

