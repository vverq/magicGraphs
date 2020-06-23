package gui;

import algorithms.*;
import graph.Edge;
import graph.Graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AlgorithmVisualizer extends GraphVisualizer {
    private HashMap<String, IAlgorithm> algortimsNameClasses = new HashMap<>(){{
        put("BFS", new BFS());
        put("DFS", new DFS());
        put("Dijkstra", new DijkstraAlgorithm());
        put("BellmanFord", new BellmanFordAlgorithm());
        put("MAXMINPath", new MAXMINPath());
    }};
    private ArrayList<Edge> edges;
    private boolean[][] adjacencyMatrix;
    private ConcurrentLinkedDeque<Edge> paintedEdges = new ConcurrentLinkedDeque<>();
    private Thread thread;
    private ArrayList<Edge> sameEdgesWithDifferentDirection = new ArrayList<>();
    private boolean isFinished;

    AlgorithmVisualizer(Graph graph, String algorithms, int source) {
        super(graph);
        adjacencyMatrix = graph.getAdjacencyMatrix();
        isFinished = false;
        edges = algortimsNameClasses.get(algorithms).invoke(graph, source, 0);
    }

    AlgorithmVisualizer(Graph graph, String algorithms, int source, int destination) {
        super(graph);
        adjacencyMatrix = graph.getAdjacencyMatrix();
        isFinished = false;
        edges = algortimsNameClasses.get(algorithms).invoke(graph, source, destination);
    }

    public void start() {
        thread = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    if (edges.size() > 0)
                        paintedEdges.add(edges.remove(0));
                    else {
                        isFinished = true;
                    }
                    try {
                        thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public boolean isFinished() { return isFinished; }

    @Override
    public void paint(Graphics g, int centerX, int centerY) {
        super.paint(g, centerX, centerY);
        var verticesCoordinates = getVerticesCoordinates(centerX, centerY);
        var x = verticesCoordinates.get(0);
        var y = verticesCoordinates.get(1);
        for (Edge edge : paintedEdges) {
            super.paintEdgeAsPro((Graphics2D)g, x[edge.getSource()], y[edge.getSource()],
                    x[edge.getDestination()], y[edge.getDestination()], false, Color.RED);
            if (sameEdgesWithDifferentDirection.contains(edge)) {
                super.paintEdgeAsPro((Graphics2D)g, x[edge.getSource()], y[edge.getSource()],
                        x[edge.getDestination()], y[edge.getDestination()], true, Color.RED);
            }
            if (adjacencyMatrix[edge.getDestination()][edge.getSource()]) {
                sameEdgesWithDifferentDirection.add(edge);
            }
        }
        for (var k = 0; k < x.length; k++) {
            super.paintNumberOfVertex((Graphics2D) g, x[k], y[k], k, Color.blue);
        }
    }
}
