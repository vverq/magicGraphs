import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

    private Graph graph;
    private ArrayList<Pair<Integer, Integer>> treeEdges;
    private ArrayList<Pair<Integer, Integer>> inverseEdges;
    private int[] verticesSequence;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Pair<Integer, Integer>> getTreeEdges() {
        return (ArrayList<Pair<Integer, Integer>>)treeEdges.clone();
    }

    public ArrayList<Pair<Integer, Integer>> getInverseEdges() {
        return (ArrayList<Pair<Integer, Integer>>)inverseEdges.clone();
    }

    public int[] getVerticesSequence() {
        return (int[])verticesSequence.clone();
    }

    public int[] doRecursiveDFS() {
        var nextNumber = 0;
        var adjacencyList = graph.getAdjacencyList();
        var n = graph.getVerticesCount();
        var num = new int[n];
        var father = new int[n];
        verticesSequence = new int[n];
        Arrays.fill(num, -1);
        treeEdges = new ArrayList<>();
        inverseEdges = new ArrayList<>();
        for (var v = 0; v < n; v++) {
            if (num[v] == -1) {
                father[v] = -1;
                nextNumber = recursiveDFS(nextNumber, v, num, adjacencyList, father);
            }
        }
        return num;
    }

    private int recursiveDFS(int nextNumber, int start, int[] num, ArrayList<ArrayList<Integer>> adjacencyList,
                             int[] father) {
        verticesSequence[nextNumber] = start;
        num[start] = nextNumber;
        nextNumber++;
        for (Integer u : adjacencyList.get(start)) {
            if (num[u] == -1) {
                treeEdges.add(new Pair<>(start, u));
                father[u] = start;
                nextNumber = recursiveDFS(nextNumber, u, num, adjacencyList, father);
            }
            else if (num[u] < num[start] && !u.equals(father[start])) {
                inverseEdges.add(new Pair<>(start, u));
            }
        }
        return nextNumber;
    }
}
