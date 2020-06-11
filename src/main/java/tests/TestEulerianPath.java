package tests;

import algorithms.EulerianPath;
import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestEulerianPath {

    private boolean[][] adjacencyMatrix1;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        var result = reader.readFile(new File("./src/main/resources/EulerianPath.txt"));
        adjacencyMatrix1 = (boolean[][])result.get(0);
    }

    @Test
    public void testNotEulerianGraph (){
        var graph = new graph.UndirectedGraph(adjacencyMatrix1);
        assertFalse(EulerianPath.isGraphEulerian(graph));
    }
}
