package tests;

import algorithms.TopologicalSort;
import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestTopologicalSort {
    private boolean[][] matrix1;
    private boolean[][] matrix2;

    @Before
    public void setUp() {
        Reader reader = new Reader();
        matrix1 = (boolean[][])reader.readFile(new File("./src/main/resources/TopologicalSort1.txt")).get(0);
        matrix2 = (boolean[][])reader.readFile(new File("./src/main/resources/TopologicalSort2.txt")).get(0);
    }

    @Test
    public void whenSimpleDirectedGraph() {
        var graph = new graph.DirectedGraph(matrix1);
        int[] expectedVertices = new int[]{1, 0, 3, 4, 2};
        assertArrayEquals(expectedVertices, TopologicalSort.topologicalSort(graph));
    }

    @Test
    public void whenDirectedGraphWithIsolatedVertexAndCycle() {
        var graph = new graph.DirectedGraph(matrix2);
        int[] expectedVertices = new int[]{3, 0, 2, 1};
        assertArrayEquals(expectedVertices, TopologicalSort.topologicalSort(graph));
    }
}
