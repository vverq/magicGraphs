package algorithms;

import graph.UndirectedGraph;

import java.util.*;

/**Класс, предоставляющий метод поиска компонент связности
*/
public class ComponentSearch {
    private ArrayList<ArrayList> components = new ArrayList<>();
    private int componentCount = 0;
    /**Метод componentSearch осуществляет поиск компонент связности,
     * используется обход в ширину. Запускается обход из первой (минимальной
     * вершины) и все вершины, которые он обошел записывается в первую компоненту
     * связности. Затем берется первая вершина из тех, которые еще не были
     * посещены, запускается обход из нее, так найдется вторая компонента
     * связности. Продолжается эта операция до тех пора, пока не останется
     * непосещенных вершин.
     * @param graph Неориентированный граф.
     * @return Массив, содержащий массивы с вершинами, входящими в одну
     * компоненту связности графа.
     */
    public ArrayList<ArrayList> componentSearch(UndirectedGraph graph) {
        int verticesCount = graph.getVerticesCount();
        boolean[][] matrix = graph.getAdjacencyMatrix();
        int currentVertex = 0;
        LinkedList<Integer> verticesToVisit = new LinkedList<>();
        HashSet<Integer> unvisitedVertices = new HashSet<>();
        ArrayList<Integer> componentVertices = new ArrayList<>();
        for (int i = 0; i < verticesCount; i++){
            unvisitedVertices.add(i);
        }
        while (true) {
            int i = 0;
            unvisitedVertices.remove(currentVertex);
            componentVertices.add(currentVertex);
            while (i < verticesCount){
                if (matrix[currentVertex][i]) {
                    if (unvisitedVertices.contains(i) && !verticesToVisit.contains(i)) {
                        verticesToVisit.add(i);
                    }
                }
                i += 1;
            }
            if (verticesToVisit.size() == 0) {
                componentCount += 1;
                components.add(componentVertices);
                componentVertices = new ArrayList<>();
                if (unvisitedVertices.size() == 0) {
                    break;
                }
                currentVertex = Collections.min(unvisitedVertices);
            }
            else {
                currentVertex = verticesToVisit.pop();
            }
        }
        return components;
    }
}