package tests.GraphColoring;

import algorithms.GraphColoring;
import org.junit.*;
import org.junit.rules.ExpectedException;
import tests.Reader;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestGraphColoring{

    private boolean[][] matrix1;
    private boolean[][] matrix2;
    private boolean[][] matrix3;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        Reader reader = new Reader();
        matrix1 = reader.readFile(new File("./src/main/java/tests/GraphColoring/in1.txt"));
        matrix2 = reader.readFile(new File("./src/main/java/tests/GraphColoring/in2.txt"));
        matrix3 = reader.readFile(new File("./src/main/java/tests/GraphColoring/in3.txt"));
    }

    @Test
    public void whenGraphWithOneIsolatedVertex(){
        graph.Graph graph = new graph.Graph(matrix1);
        int[] coloring = new int[]{1, 2, 1, 1};
        System.out.println(Arrays.toString(new GraphColoring().graphColoring(graph)));
        assertArrayEquals(coloring, new algorithms.GraphColoring().graphColoring(graph));
    }

    @Test
    public void whenGraphWithAllIsolatedVertexes(){
        graph.Graph graph = new graph.Graph(matrix2);
        int[] coloring = new int[]{1, 1, 1};
        assertArrayEquals(coloring, new algorithms.GraphColoring().graphColoring(graph));
    }

    @Test
    public void whenGraphWithoutIsolatedVertexes(){
        graph.Graph graph = new graph.Graph(matrix3);
        int[] coloring = new int[]{1, 2, 1, 3, 2};
        assertArrayEquals(coloring, new algorithms.GraphColoring().graphColoring(graph));
    }
}
