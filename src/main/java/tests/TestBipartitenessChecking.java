package tests;
import algorithms.BipartitenessChecking;
import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBipartitenessChecking {
    private boolean[][] adjacencyMatrix1;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/BipartitenessChecking.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
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
