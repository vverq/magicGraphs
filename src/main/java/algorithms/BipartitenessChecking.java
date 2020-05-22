package algorithms;

import graph.Graph;
import graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BipartitenessChecking
{

    public static boolean checkGraph(UndirectedGraph graph) {
        return getPartition(graph) != null;
    }

    public static int[] getPartition(UndirectedGraph graph) {
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        var stack = new ArrayList<Integer>();
        stack.add(0);
        var values = new int[adjacencyMatrix.length];
        Arrays.fill(values, -1);
        while (true) {
            var flag = true;
            if (!check(adjacencyMatrix, values, stack))
                return null;
            for (var i = 0; i < values.length; i++) {
                if (values[i] == -1) {
                    stack = new ArrayList<Integer>();
                    stack.add(i);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return values;
            }
        }
    }
    private static boolean check(boolean[][] adjacencyMatrix, int[] values, ArrayList<Integer> stack) {
        while (stack.size() != 0) {
            var currentTop = stack.get(stack.size() - 1);
            if (values[currentTop] == -1)
                values[currentTop] = 0;
            for (var top = 0; top < adjacencyMatrix.length; top++) {
                if (top == currentTop
                        || (stack.size() > 1
                        && top == stack.get(stack.size() - 2))) {
                    continue;
                }
                if (adjacencyMatrix[currentTop][top]) {
                    if (values[top] == -1) {
                        stack.add(top);
                        values[top] = (values[currentTop] + 1) % 2;
                        if (!check(adjacencyMatrix, values, stack))
                            return false;
                    }
                    if (values[currentTop] % 2 == values[top] % 2)
                        return false;
                }
            }
            if (stack.isEmpty())
                return true;
            stack.remove(stack.size() - 1);
        }
        return true;
    }
}

