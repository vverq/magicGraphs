class Edge implements Comparable<Edge>
{
    int source;
    int destination;
    int weight;

    Edge(int src, int dst, int w)
    {
        source = src;
        destination = dst;
        weight = w;
    }

    Edge()
    {
        source = -1;
        destination = -1;
    }

    public int compareTo(Edge compareEdge)
    {
        return this.weight-compareEdge.weight;
    }
}
