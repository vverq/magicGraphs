package tests;
import algorithms.MAXMINPath;
import graph.Edge;
import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMAXMINPath {
    private boolean[][] adjacencyMatrix1;
    private int[][] weightMatrix1;
    private MAXMINPath maxminPath;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/MaxminPath.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        weightMatrix1 = (int[][])result.get(1);
        maxminPath = new MAXMINPath();
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        var expected = new Edge[2];
        expected[0] = new Edge(0, 2);
        expected[1] = new Edge(2, 4);
        assertArrayEquals(expected, maxminPath.invoke(graph, 0, 4).toArray());
    }
}

