package tests.BipartitenessChecking;
import algorithms.BipartitenessChecking;
import org.junit.*;
import tests.Reader;

import java.io.File;

import static org.junit.Assert.*;

public class TestBipartitenessChecking {
    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/BipartitenessChecking/in1.txt"));
        adjacencyMatrix1 = result.getKey();
    }

    @Test
    public void checkBipartiteGraph(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix1);
        var expected = new int[5];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 1;
        expected[3] = 0;
        expected[4] = 1;
        assertArrayEquals(expected, BipartitenessChecking.getPartition(graph));
    }
}