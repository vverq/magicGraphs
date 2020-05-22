package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader{

    public Reader() {}

    public boolean[][] readFile(File filename) {
        try (FileReader reader = new FileReader(filename)) {
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            int n = Integer.parseInt(line);
            boolean[][] matrix = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                line = r.readLine();
                String[] values = line.split(", ");
                for (int j = 0; j < values.length; j++) {
                    matrix[i][j] = Boolean.parseBoolean(values[j]);
                }
            }
            return matrix;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
