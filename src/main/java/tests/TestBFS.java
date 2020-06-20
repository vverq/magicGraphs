package tests;
import algorithms.BFS;
import algorithms.DFS;
import graph.Edge;
import graph.UndirectedGraph;
import utilities.Reader;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBFS {
    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/BFS1.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        result = reader.readFile(new File("./src/main/resources/BFS2.txt"));
        adjacencyMatrix2 = (boolean[][])result.get(0);
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 1));
        expectedEdges.add(new Edge(0, 2));
        expectedEdges.add(new Edge(1, 2));
        expectedEdges.add(new Edge(1, 3));
        expectedEdges.add(new Edge(2, 3));
        expectedEdges.add(new Edge(2, 4));
        expectedEdges.add(new Edge(3, 4));
        ArrayList<Edge> actualEdges = BFS.BFS(graph, 0);
        for (int i = 0; i < actualEdges.size(); i++) {
            assertEquals(expectedEdges.get(i), actualEdges.get(i));
        }
    }

    @Test
    public void whenUndirectedGraph(){
        UndirectedGraph graph = new graph.UndirectedGraph(adjacencyMatrix2);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 1));
        expectedEdges.add(new Edge(0, 2));
        expectedEdges.add(new Edge(1, 0));
        expectedEdges.add(new Edge(1, 3));
        expectedEdges.add(new Edge(2, 0));
        expectedEdges.add(new Edge(2, 3));
        expectedEdges.add(new Edge(3, 1));
        expectedEdges.add(new Edge(3, 2));
        expectedEdges.add(new Edge(3, 4));
        expectedEdges.add(new Edge(4, 3));
        ArrayList<Edge> actualEdges = BFS.BFS(graph, 0);
        for (int i = 0; i < actualEdges.size(); i++) {
            assertEquals(expectedEdges.get(i), actualEdges.get(i));
        }
    }
}
