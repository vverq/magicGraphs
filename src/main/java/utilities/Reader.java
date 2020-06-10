package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Класс, предоставляющий функциональность для парсинга текстовых файлов с заданным графом.
 */
public class Reader{

    public Reader() {}

    /** Метод парсит переданный файл в соотвествии с протоколом оформления.
     * @param filename Файл.
     * @return Возвращает список, в котором первый элемент - это матрица смежности,
     * а второй - матрица весов.
     */
    public ArrayList readFile(File filename) {
        try (FileReader reader = new FileReader(filename)) {
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            int n = Integer.parseInt(line);
            var adjacencyMatrix = new boolean[n][n];
            var weightMatrix = new int[n][n];
            while ((line = r.readLine()) != null) {
                String[] values = line.split(" ");
                var v = Integer.parseInt(values[0]);
                var w = Integer.parseInt(values[1]);
                var c = Integer.parseInt(values[2]);
                adjacencyMatrix[v][w] = true;
                weightMatrix[v][w] = c;
            }
            var result = new ArrayList();
            result.add(adjacencyMatrix);
            result.add(weightMatrix);
            return result;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
