package tests;

import utilities.Reader;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestHamiltonianCycle {

    private boolean[][] matrix1;
    private boolean[][] matrix2;
    private boolean[][] matrix3;

    @Before
    public void setUp() {
        Reader reader = new Reader();
        matrix1 = (boolean[][])reader.readFile(new File("./src/main/resources/HamiltonianCycle1.txt")).get(0);
        matrix2 = (boolean[][])reader.readFile(new File("./src/main/resources/HamiltonianCycle2.txt")).get(0);
        matrix3 = (boolean[][])reader.readFile(new File("./src/main/resources/HamiltonianCycle3.txt")).get(0);
    }

    @Test
    public void whenGraphWithSimpleCycle() {
        graph.Graph graph = new graph.Graph(matrix1);
        int[] expectedCycle = new int[]{0, 1, 2, 3, 0};
        assertArrayEquals(expectedCycle, new algorithms.HamiltonianCycle().hamiltonianCycle(graph));
    }

    @Test
    public void whenGraphWithCycle() {
        graph.Graph graph = new graph.Graph(matrix2);
        int[] expectedCycle = new int[]{0, 1, 4, 2, 3, 0};
        assertArrayEquals(expectedCycle, new algorithms.HamiltonianCycle().hamiltonianCycle(graph));
    }

    @Test
    public void whenGraphWithoutCycle() {
        graph.Graph graph = new graph.Graph(matrix3);
        int[] expectedCycle = new int[5];
        assertArrayEquals(expectedCycle, new algorithms.HamiltonianCycle().hamiltonianCycle(graph));
    }
}
