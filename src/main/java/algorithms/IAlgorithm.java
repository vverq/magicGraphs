package algorithms;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;

public interface IAlgorithm {
    ArrayList<Edge> invoke(Graph graph, int start, int finish);
}