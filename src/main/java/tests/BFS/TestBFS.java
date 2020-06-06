package tests.BFS;
import algorithms.BFS;
import org.junit.*;
import tests.Reader;

import java.io.File;

import static org.junit.Assert.*;

public class TestBFS {
    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/BFS/in1.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        result = reader.readFile(new File("./src/main/java/tests/BFS/in1.txt"));
        adjacencyMatrix2 = (boolean[][])result.get(0);
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        var expected = new int[5];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 3;
        expected[4] = 4;
        assertArrayEquals(expected, BFS.BFS(graph, 0));
    }

    @Test
    public void whenUndirectedGraph(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix2);
        var expected = new int[5];
        expected[0] = 4;
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 0;
        expected[4] = 3;
        assertArrayEquals(expected, BFS.BFS(graph, 3));
    }
}
