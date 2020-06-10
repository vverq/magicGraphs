package gui;

import graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class GraphVisualizer extends JPanel {

    private Graph graph;

    public GraphVisualizer(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        var n = graph.getVerticesCount();
        var r = 100;
        var centerX = getWidth() / 2;
        var centerY = getHeight() / 2;
        var angle = 0.0;
        var x = new int[n];
        var y = new int[n];
        var angles = new double[n];
        for (var i = 0; i < n; i++) {
            angle = 2 * Math.PI * i / n;
            angles[i] = angle;
            x[i] = (int)Math.round(r * Math.cos(angle) + centerX);
            y[i] = (int)Math.round(r * Math.sin(angle) + centerY);
            g.setColor(Color.BLACK);
            g.fillOval(x[i] - 4, y[i] - 4, 8, 8);
        }
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (adjacencyMatrix[i][j]) {
                    g.drawLine(x[i], y[i], x[j], y[j]);
//                    var xPoints = new int[3];
//                    xPoints[0] = x[j];
//                    xPoints[1] = x[j] + 10;
//                    xPoints[2] = x[j] + 10;
//                    var yPoints = new int[3];
//                    yPoints[0] = y[j];
//                    yPoints[1] = y[j] + 6;
//                    yPoints[2] = y[j] - 6;
                    if (1 == 1) {
                        AffineTransform t = AffineTransform.getRotateInstance(getAngle(x[i], y[i], x[j], y[j]), x[j], y[j]);
//                        ((Graphics2D) g).setTransform(t);
//                        g.fillPolygon(xPoints, yPoints, 3);
                        g.drawLine(x[j], y[j], x[j] + 10, y[j] - 8);
                        g.drawLine(x[j], y[j], x[j] + 10, y[j] + 8);
                        t = AffineTransform.getRotateInstance(0, x[j], y[j]);
//                        ((Graphics2D) g).setTransform(t);
                    }
                }
            }
        }

    }

    public double getAngle (int x2, int y2, int x1, int y1) {
        return Math.atan2(y1 - y2, x2 - x1);
    }
}
