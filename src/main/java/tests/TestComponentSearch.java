package tests;

import org.junit.*;
import utilities.Reader;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestComponentSearch {

    private boolean[][] matrix1;
    private boolean[][] matrix2;

    @Before
    public void setUp() {
        Reader reader = new Reader();
        matrix1 = (boolean[][])reader.readFile(new File("./src/main/resources/ComponentSearch1.txt")).get(0);
        matrix2 = (boolean[][])reader.readFile(new File("./src/main/resources/ComponentSearch2.txt")).get(0);
    }

    @Test
    public void whenGraphWithOneComponent() {
        graph.UndirectedGraph graph = new graph.UndirectedGraph(matrix1);
        ArrayList<ArrayList> components = new ArrayList<>(){};
        ArrayList component = new ArrayList();
        for (int i = 0; i < 5; i++){
            component.add(i);
        }
        components.add(component);
        assertEquals(components, new algorithms.ComponentSearch().componentSearch(graph));
    }

    @Test
    public void whenGraphWithSeveralComponent() {
        graph.UndirectedGraph graph = new graph.UndirectedGraph(matrix2);
        ArrayList<ArrayList> components = new ArrayList<>(){};
        ArrayList component = new ArrayList();
        for (int i = 0; i < 3; i++){
            component.add(i);
        }
        components.add(component);
        component = new ArrayList();
        component.add(3);
        components.add(component);
        assertEquals(components, new algorithms.ComponentSearch().componentSearch(graph));
    }
}
