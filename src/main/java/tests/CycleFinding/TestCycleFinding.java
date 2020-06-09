package tests.CycleFinding;
import algorithms.CycleFinding;
import org.junit.*;
import tests.Reader;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCycleFinding {
    private boolean[][] adjacencyMatrix1;
    private boolean[][] adjacencyMatrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/java/tests/CycleFinding/in.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
        result = reader.readFile(new File("./src/main/java/tests/CycleFinding/in2.txt"));
        adjacencyMatrix2 = (boolean[][])result.get(0);
    }

    @Test
    public void whenDirectedGraph(){
        var graph = new graph.DirectedGraph(adjacencyMatrix1);
        assertTrue(CycleFinding.isGraphAcyclic(graph));
    }

    @Test
    public void whenUndirectedGraph(){
        var graph = new graph.UndirectedGraph(adjacencyMatrix2);
        assertFalse(CycleFinding.isGraphAcyclic(graph));
        var result = CycleFinding.getCycle(graph);
        for (var i = 0; i < 3; i++)
            assertTrue(result.contains(i));
    }
}
