import java.util.ArrayList;

public class GraphFactory {
    //читает матрицу смежности из строки
    public static boolean[][] getGraphMatrixFromString(String strMatrix) {
        var splittedStrMatrix = strMatrix.split("\n");
        var matrix = new boolean[splittedStrMatrix.length][splittedStrMatrix.length];
        for (var i = 0; i < splittedStrMatrix.length; i++) {
            var splittedLine = splittedStrMatrix[i].split(" ");
            for (var j = 0; j < splittedStrMatrix.length; j++) {
                matrix[i][j] = splittedLine[j].equals("1");
            }
        }
        return matrix;
    }
    //читает матрицу весов из строки
    public static int[][] geWeightMatrixFromString(String strMatrix) {
        var splittedStrMatrix = strMatrix.split("\n");
        var matrix = new int[splittedStrMatrix.length][splittedStrMatrix.length];
        for (var i = 0; i < splittedStrMatrix.length; i++) {
            var splittedLine = splittedStrMatrix[i].split(" ");
            for (var j = 0; j < splittedStrMatrix.length; j++) {
                matrix[i][j] = Integer.parseInt(splittedLine[j]);
            }
        }
        return matrix;
    }

}
