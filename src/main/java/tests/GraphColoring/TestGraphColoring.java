package tests.GraphColoring;

import org.junit.*;
import org.junit.rules.ExpectedException;
import tests.Reader;

import static org.junit.Assert.*;


public class TestGraphColoring{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        Reader reader1 = new Reader();
        reader1.readFile("in1.txt");
        boolean[][] matrix1 = reader1.getMatrix();
    }

    @Test
    public void whenSimpleGraph(){
//        Graph graph = new Graph(adjMatrix);
//        assertArrayEquals(new int[]{1,2,3,4}, new GraphColoring().graphColoring(graph));
    }
}
