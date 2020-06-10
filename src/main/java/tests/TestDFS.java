package tests;

import algorithms.DFS;
import org.junit.Before;
import org.junit.Test;
import tests.Reader;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestDFS {
    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        adjacencyMatrix1 = (boolean[][])reader.readFile(new File("./src/main/resources/DFS1.txt")).get(0);
        adjacencyMatrix2 = (boolean[][])reader.readFile(new File("./src/main/resources/DFS2.txt")).get(0);
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix2);
        var expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(3);
        expected.add(1);
        expected.add(4);
        expected.add(2);
        assertEquals(expected, DFS.DFS(graph, 0));
    }

    @Test
    public void whenUndirectedGraph(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix1);
        var expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(3);
        expected.add(2);
        expected.add(7);
        expected.add(6);
        expected.add(1);
        expected.add(4);
        expected.add(5);
        assertEquals(expected, DFS.DFS(graph, 0));
    }
}