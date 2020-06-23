package tests;

import algorithms.DijkstraAlgorithm;
import graph.Edge;
import utilities.Reader;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestDijkstraAlgorithm {
    private boolean[][] adjacencyMatrix1;
    private int[][] weightMatrix1;
    private DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

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
        var expectedEdges = new Edge[2];
        expectedEdges[0] = new Edge(0,2);
        expectedEdges[1] = new Edge(2,4);
        assertArrayEquals(expectedEdges, dijkstraAlgorithm.invoke(graph, 0, 4).toArray());
    }
}
