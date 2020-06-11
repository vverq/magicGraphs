package tests;

import algorithms.GraphColoring;
import utilities.Reader;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestGraphColoring {

    private boolean[][] matrix1;
    private boolean[][] matrix2;
    private boolean[][] matrix3;

    @Before
    public void setUp() {
        Reader reader = new Reader();
        matrix1 = (boolean[][])reader.readFile(new File("./src/main/resources/GraphColoring1.txt")).get(0);
        matrix2 = (boolean[][])reader.readFile(new File("./src/main/resources/GraphColoring2.txt")).get(0);
        matrix3 = (boolean[][])reader.readFile(new File("./src/main/resources/GraphColoring3.txt")).get(0);
    }

    @Test
    public void whenGraphWithOneIsolatedVertex() {
        graph.Graph graph = new graph.Graph(matrix1);
        int[] coloring = new int[]{1, 2, 1, 1};
        System.out.println(Arrays.toString(new GraphColoring().graphColoring(graph)));
        assertArrayEquals(coloring, new algorithms.GraphColoring().graphColoring(graph));
    }

    @Test
    public void whenGraphWithAllIsolatedVertexes() {
        graph.Graph graph = new graph.Graph(matrix2);
        int[] coloring = new int[]{1, 1, 1};
        assertArrayEquals(coloring, new algorithms.GraphColoring().graphColoring(graph));
    }

    @Test
    public void whenGraphWithoutIsolatedVertexes() {
        graph.Graph graph = new graph.Graph(matrix3);
        int[] coloring = new int[]{1, 2, 1, 3, 2};
        assertArrayEquals(coloring, new algorithms.GraphColoring().graphColoring(graph));
    }
}
