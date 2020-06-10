package tests;

import graph.Edge;
import graph.Graph;
import org.junit.*;
import tests.Reader;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestMST {
    private boolean[][] adjacencyMatrix;
    private int[][] weightMatrix;

    @Before
    public void setUp() {
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/MST.txt"));
        adjacencyMatrix = (boolean[][])result.get(0);
        weightMatrix = (int[][])result.get(1);
    }

    @Test
    public void testMSTBoruvka() {
        Graph graph = new Graph(adjacencyMatrix);
        graph.setWeightMatrix(weightMatrix);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 3, 5));
        expectedEdges.add(new Edge(0, 1, 10));
        expectedEdges.add(new Edge(2, 3, 4));
        ArrayList<Edge> actualMST = new algorithms.MSTBoruvka().BoruvkaMST(graph);
        for (int i = 0; i < expectedEdges.size(); i++) {
            assertEquals(expectedEdges.get(i).getSource(), actualMST.get(i).getSource());
            assertEquals(expectedEdges.get(i).getDestination(), actualMST.get(i).getDestination());
            assertEquals(expectedEdges.get(i).getWeight(), actualMST.get(i).getWeight());
        }
    }

    @Test
    public void testMSTKruskal() {
        graph.Graph graph = new graph.Graph(adjacencyMatrix);
        graph.setWeightMatrix(weightMatrix);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 3, 5));
        expectedEdges.add(new Edge(0, 1, 10));
        expectedEdges.add(new Edge(2, 3, 4));
        ArrayList<Edge> actualMST = new algorithms.MSTKruskal().KruskalMST(graph);
        for (int i = 0; i < expectedEdges.size(); i++) {
            assertEquals(expectedEdges.get(i).getSource(), actualMST.get(i).getSource());
            assertEquals(expectedEdges.get(i).getDestination(), actualMST.get(i).getDestination());
            assertEquals(expectedEdges.get(i).getWeight(), actualMST.get(i).getWeight());
        }
    }

    @Test
    public void testMSTPrim() {
        graph.Graph graph = new graph.Graph(adjacencyMatrix);
        graph.setWeightMatrix(weightMatrix);
        ArrayList<Edge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new Edge(0, 3, 5));
        expectedEdges.add(new Edge(0, 1, 10));
        expectedEdges.add(new Edge(2, 3, 4));
        ArrayList<Edge> actualMST = new algorithms.MSTKruskal().KruskalMST(graph);
        for (int i = 0; i < expectedEdges.size(); i++) {
            assertEquals(expectedEdges.get(i).getSource(), actualMST.get(i).getSource());
            assertEquals(expectedEdges.get(i).getDestination(), actualMST.get(i).getDestination());
            assertEquals(expectedEdges.get(i).getWeight(), actualMST.get(i).getWeight());
        }
    }
}
