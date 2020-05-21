package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private int n;
    private boolean[][] matrix;

    // пока только булеан, потом нжно что-то придумать, боюсь писать общее

    public Reader(){}

    public void readFile(String filename){
        try(FileReader reader = new FileReader(filename)){
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            n = Integer.parseInt(line);
            matrix = new boolean[n][n];
            for (int i = 0; i < n; i++){
                line = r.readLine();
                String[] values = line.split(", ");
                for (int j = 0; j < values.length; j++){
                    matrix[i][j] = Boolean.parseBoolean(values[j]);
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public int getCountVertices(){
        return n;
    }

    public boolean[][] getMatrix(){
        return matrix;
    }
}
