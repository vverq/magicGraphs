package tests.ComponentSearch;

import org.junit.*;
import tests.Reader;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestComponentSearch{

    private boolean[][] matrix1;
    private boolean[][] matrix2;

    @Before
    public void setUp(){
        Reader reader = new Reader();
        matrix1 = reader.readFile(new File("./src/main/java/tests/ComponentSearch/in1.txt"));
      //  matrix2 = reader.readFile(new File("./src/main/java/tests/ComponentSearch/in2.txt"));
    }

    @Test
    public void whenGraphWithOneComponent(){
        graph.UndirectedGraph graph = new graph.UndirectedGraph(matrix1);
        ArrayList<ArrayList> components = new ArrayList<>(){};
        ArrayList component = new ArrayList();
        for (int i = 0; i < 5; i++){
            component.add(i);
        }
        components.add(component);
        assertSame(components, new algorithms.ComponentSearch().componentSearch(graph));
    }
}
