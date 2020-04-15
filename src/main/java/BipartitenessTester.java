import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BipartitenessTester {

    public boolean checkGraph(Graph graph) {
        return getPartition(graph) != null;
    }

    public int[] getPartition(Graph graph) {
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        var stack = new Stack<Integer>();
        stack.push(0);
        var values = new int[adjacencyMatrix.length];
        Arrays.fill(values, -1);
        while (true) {
            var flag = true;
            if (!check(adjacencyMatrix, values, stack))
                return null;
            for (var i = 0; i < values.length; i++) {
                if (values[i] == -1) {
                    stack = new Stack<Integer>();
                    stack.push(i);
                    flag = false;
                    break;
                }
            }
            if (flag)
                return values;
        }
    }
    private boolean check(Integer[][] adjacencyMatrix, int[] values, Stack<Integer> stack) {
        while (!stack.empty()) {
            var currentTop = stack.peek();
            if (values[currentTop] == -1)
                values[currentTop] = 0;
            for (var top = 0; top < adjacencyMatrix.length; top++) {
                if (top == currentTop
                        || (stack.size() > 1
                        && top == stack.elementAt(stack.size() - 2))) {
                    continue;
                }
                if (adjacencyMatrix[currentTop][top] == 1) {
                    if (values[top] == -1) {
                        stack.push(top);
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
            stack.pop();
        }
        return true;
    }
}

