package tests;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader{

    public Reader() {}

    public Pair<boolean[][], int[][]> readFile(File filename) {
        try (FileReader reader = new FileReader(filename)) {
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            int n = Integer.parseInt(line);
            boolean[][] adjacencyMatrix = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                line = r.readLine();
                String[] values = line.split(" ");
                for (int j = 0; j < n; j++) {
                    adjacencyMatrix[i][j] = values[j].equals("1");
                }
            }
            line = r.readLine();
            if (line.equals("N"))
                return new Pair<>(adjacencyMatrix, new int[n][n]);
            var weightMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                line = r.readLine();
                String[] values = line.split(" ");
                for (int j = 0; j < n; j++) {
                    weightMatrix[i][j] = Integer.parseInt(values[j]);
                }
            }
            return new Pair<>(adjacencyMatrix, weightMatrix);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
