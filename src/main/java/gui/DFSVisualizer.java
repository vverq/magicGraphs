package gui;

import algorithms.DFS;
import graph.Graph;
import graph.Edge;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DFSVisualizer extends GraphVisualizer {
    private ArrayList<Edge> edges;
    private ArrayList<Edge> paintedEdges = new ArrayList<>();
    private final Timer m_timer = initTimer();
    private static Timer initTimer()
    {
        Timer timer = new Timer("events generator", true);
        return timer;
    }
    DFSVisualizer(Graph graph) {
        super(graph);
        edges = DFS.DFS(graph, 0);
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                if (edges.size() > 0)
                    paintedEdges.add(edges.remove(0));
            }
        }, 0, 2000);
    }

    @Override
    public void paint(Graphics g, int centerX, int centerY) {
        super.paint(g, centerX, centerY);
        var verticesCoordinates = getVerticesCoordinates(centerX, centerY);
        var x = verticesCoordinates.get(0);
        var y = verticesCoordinates.get(1);
        for (Edge edge : paintedEdges) {
            super.paintEdge((Graphics2D)g, x[edge.getSource()], y[edge.getSource()],
                    x[edge.getDestination()], y[edge.getDestination()], Color.RED, Color.GREEN);
        }
    }
}
