package tests.MST;

import graph.Edge;
import org.junit.*;
import tests.Reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestMST {
    private boolean[][] adjacencyMatrix1;
    private int[][] weightMatrix1;

    @Before
    public void setUp() {
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/MST/in1.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        weightMatrix1 = (int[][])result.get(1);
    }

    @Test
    public void testMSTBoruvka() {
        graph.Graph graph = new graph.Graph(adjacencyMatrix1);
        graph.setWeightMatrix(weightMatrix1);
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(6, 0, 1));
        edges.add(new Edge(0, 1, 3));
        edges.add(new Edge(1, 2, 7));
        edges.add(new Edge(1, 3, 11));
        edges.add(new Edge(4, 5, 1));
        assertEquals(edges, new algorithms.MSTBoruvka().BoruvkaMST(graph));
    }
}
