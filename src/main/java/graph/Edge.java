package graph;

public class Edge implements Comparable<Edge>
{
    private int source;
    private int destination;
    private int weight;

    Edge(int src, int dst, int w)
    {
        source = src;
        destination = dst;
        weight = w;
    }

    Edge(int src, int dst)
    {
        source = src;
        destination = dst;
    }

    public Edge()
    {
        source = -1;
        destination = -1;
    }

    public void setWeight(int w) {weight = w; }

    public int getWeight() { return weight; }

    public int getSource() { return source; }

    public int getDestination() {
        return destination;
    }

    public int compareTo(Edge compareEdge)
    {
        return this.weight-compareEdge.weight;
    }
}
