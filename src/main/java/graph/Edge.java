package graph;

import java.util.Objects;

/** Класс ребра.
 */
public class Edge implements Comparable<Edge>
{
    private int source;
    private int destination;
    private int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return source == edge.source &&
                destination == edge.destination &&
                weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }

    /** Инициализирует приватные поля source, destination, weight переданными значениями.
     * @param src Номер вершины, из которой исходит ребро.
     * @param dst Номер вершины, в которую входит ребро.
     * @param w Вес ребра.
     */
    public Edge(int src, int dst, int w)
    {
        source = src;
        destination = dst;
        weight = w;
    }

    /** Инициализирует приватные поля source, destination переданными значениями.
     * @param src Номер вершины, из которой исходит ребро.
     * @param dst Номер вершины, в которую входит ребро.
     */
    public Edge(int src, int dst)
    {
        source = src;
        destination = dst;
    }

    /** Инициализирует приватные поля source, destination.
     */
    public Edge()
    {
        source = -1;
        destination = -1;
    }

    /** Сеттер приватного поля weight.
     * @param w Вес ребра.
     */
    public void setWeight(int w) {weight = w; }

    /** Геттер приватного поля weight.
     * @return Вес ребра.
     */
    public int getWeight() { return weight; }

    /** Геттер приватного поля source.
     * @return Номер вершины, из которой исходит ребро.
     */
    public int getSource() { return source; }

    /** Геттер приватного поля destination.
     * @return Номер вершины, в которую входит ребро.
     */
    public int getDestination() {
        return destination;
    }

    /** Метод считает разницу между весами данного и переданного ребер.
     * @return Разница между весами данного и переданного ребер.
     */
    public int compareTo(Edge compareEdge)
    {
        return this.weight-compareEdge.weight;
    }
}
