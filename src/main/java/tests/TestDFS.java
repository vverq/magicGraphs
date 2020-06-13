package tests;

import algorithms.DFS;
import graph.DirectedGraph;
import graph.Edge;
import org.junit.Before;
import org.junit.Test;
import utilities.Reader;

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
        DirectedGraph graph = new graph.DirectedGraph(adjacencyMatrix2);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 2));
        expectedEdges.add(new Edge(2, 3));
        expectedEdges.add(new Edge(3, 4));
        expectedEdges.add(new Edge(0, 1));
        expectedEdges.add(new Edge(1, 3));
        ArrayList<Edge> actualEdges = DFS.DFS(graph, 0);
        for (int i = 0; i < actualEdges.size(); i++) {
            assertEquals(expectedEdges.get(i), actualEdges.get(i));
        }
    }

    @Test
    public void whenUndirectedGraph(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix1);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 3));
        expectedEdges.add(new Edge(3, 0));
        expectedEdges.add(new Edge(0, 2));
        expectedEdges.add(new Edge(2, 7));
        expectedEdges.add(new Edge(7, 2));
        expectedEdges.add(new Edge(2, 6));
        expectedEdges.add(new Edge(6, 2));
        expectedEdges.add(new Edge(2, 0));
        expectedEdges.add(new Edge(0, 1));
        expectedEdges.add(new Edge(1, 4));
        expectedEdges.add(new Edge(4, 5));
        expectedEdges.add(new Edge(5, 4));
        expectedEdges.add(new Edge(4, 1));
        expectedEdges.add(new Edge(1, 0));
        ArrayList<Edge> actualEdges = DFS.DFS(graph, 0);
        for (int i = 0; i < actualEdges.size(); i++) {
            assertEquals(expectedEdges.get(i), actualEdges.get(i));
        }
    }
}