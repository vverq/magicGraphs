import java.util.ArrayList;

public class GraphFactory {

    public Graph getGraphFromMatrix(boolean[][] matrix) {
        return new Graph(matrixToAdjacencyList(matrix), matrix);
    }

    public Graph getGraphFromList(ArrayList<ArrayList<Integer>> adjacencyList) {
        return new Graph(adjacencyList, adjacencyListToMatrix(adjacencyList));
    }

//    для парсинга матриц вида "0 0 1\n1 0 0\n0 0 0", потом удобно будет в тестах использовать
    public Graph getGraphFromString(String strMatrix) {
        var splittedStrMatrix = strMatrix.split("\n");
        var matrix = new boolean[splittedStrMatrix.length][splittedStrMatrix.length];
        for (var i = 0; i < splittedStrMatrix.length; i++) {
            var splittedLine = splittedStrMatrix[i].split(" ");
            for (var j = 0; j < splittedStrMatrix.length; j++) {
                matrix[i][j] = splittedLine[j].equals("1");
            }
        }
        return new Graph(matrixToAdjacencyList(matrix), matrix);
    }

    private boolean[][] adjacencyListToMatrix(ArrayList<ArrayList<Integer>> adjacencyList)
    {
        var n = adjacencyList.size();
        var matrix = new boolean[n][n];
        for (var i = 0; i < n; i++) {
            var currentList = adjacencyList.get(i);
            for (var j = 0; j < n; j++) {
                matrix[i][j] = currentList.contains(j);
            }
        }
        return matrix;
    }

    private ArrayList<ArrayList<Integer>> matrixToAdjacencyList(boolean[][] matrix)
    {
        var n = matrix.length;
        var adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (var i = 0; i < n; i++) {
            var currentList = new ArrayList<Integer>();
            for (var j = 0; j < n; j++) {
                if (matrix[i][j])
                    currentList.add(j);
            }
            adjacencyList.add(currentList);
        }
        return adjacencyList;
    }
}
