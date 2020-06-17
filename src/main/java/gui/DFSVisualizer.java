package gui;

import algorithms.DFS;
import graph.Graph;
import graph.Edge;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DFSVisualizer extends GraphVisualizer {
    private ArrayList<Edge> edges;
    private boolean[][] adjacencyMatrix;
    private ConcurrentLinkedDeque<Edge> paintedEdges = new ConcurrentLinkedDeque<>();
    private Thread thread;
    private ArrayList<Edge> sameEdgesWithDifferentDirection = new ArrayList<>();
    private boolean isFinished;

    DFSVisualizer(Graph graph) {
        super(graph);
        adjacencyMatrix = graph.getAdjacencyMatrix();
        edges = DFS.DFS(graph, 0);
        isFinished = false;
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
                        thread.sleep(2000);
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
    }
}
