package tests;

import algorithms.DijkstraAlgorithm;
import org.junit.*;
import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;


public class TestDijkstraAlgorithm {

    private boolean[][] adjacencyMatrix1;
    private int[][] weightMatrix1;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/Dijkstra.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        weightMatrix1 = (int[][])result.get(1);
    }

    @Test
    public void test1 (){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        var expected = new int[3];
        expected[0] = 0;
        expected[1] = 2;
        expected[2] = 4;
        assertArrayEquals(expected, DijkstraAlgorithm.getShortestPath(graph, 0, 4));
    }
}