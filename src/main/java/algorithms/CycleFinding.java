package algorithms;

import graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class CycleFinding {
    public static boolean isGraphAcyclic(Graph graph) {
        return getCycle(graph) != null;
    }
    public static ArrayList<Integer> getCycle(Graph graph) {
        var cycle = new ArrayList<Integer>();
        var stack = new Stack<Integer>();
        stack.push(0);
        var values = new int[graph.getVerticesCount()];
        while (true) {
            var cycleTop = checkGraph(graph, values, stack);
            if (cycleTop != null) {
                var t = stack.pop();
                while (t != cycleTop) {
                    cycle.add(t);
                    t = stack.pop();
                }
                return cycle;
            }
            var flag = true;
            for (var i = 0; i < graph.getVerticesCount(); i++) {
                if (values[i] == 0) {
                    stack = new Stack<>();
                    stack.push(i);
                    flag = false;
                    break;
                }
            }
            if (flag)
                return null;
        }
    }

    private static Integer checkGraph(Graph graph, int[] values, Stack<Integer> stack) {
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        while(!stack.isEmpty()) {
            var currentTop = stack.pop();
            stack.push(currentTop);
            if (values[currentTop] == 0)
                values[currentTop] = 1;
            var flag = false;
            for (var t = 0; t < graph.getVerticesCount(); t++) {
                if (t == currentTop || (stack.size() > 1 && stack.get(stack.size() - 2) == t))
                    continue;
                if (adjacencyMatrix[currentTop][t]) {
                    if (stack.contains(t))
                        return t;
                    if (values[t] == 0) {
                        stack.push(t);
                        flag = true;
                        break;
                    }

                }
            }
            if (flag)
                continue;
            stack.pop();
        }
        return null;
    }
}
