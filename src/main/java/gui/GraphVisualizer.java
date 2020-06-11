package gui;

import graph.Graph;

import javax.swing.*;
import java.awt.*;

public class GraphVisualizer extends JPanel {

    private Graph graph;

    GraphVisualizer(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        var n = graph.getVerticesCount();
        var r = 300;
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
            g.fillOval(x[i] - 4, y[i] - 8, 16, 16);
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));
            g.drawString(i+"", x[i] - 16, y[i] + 16);
            g.setColor(Color.black);
        }
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (adjacencyMatrix[i][j]) {
                        int d = (int)Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
                        int ax = x[i];
                        int ay = y[i];
                        int bx = x[j];
                        int by = y[j];
                        int deltaX = bx - ax;
                        int deltaY = by - ay;
                        int X = Math.min(ax, bx);
                        int Y = Math.min(ay, by);
                        int width = Math.abs(ax - bx);
                        int height = Math.abs(ay - by);
                        if (deltaX <= 0 && deltaY <=0) {
                            g2d.drawArc(X, Y - height, width * 2, height * 2, 180, 90);
                            g2d.setColor(Color.green);
                            int l = 8;
                            int abx = (int)((double)(bx - ax + (width/2)) / d * l);
                            int aby = (int)((double)(by - ay - (width/2) )/ d * l);
                            int abx1 = aby;
                            int aby1 = -abx;
                            g.drawPolygon(new int [] {bx, bx-abx1-3*abx, bx+abx1-3*abx}, new int [] {by, by-aby1-3*aby, by+aby1-3*aby}, 3);
                            g2d.setColor(Color.black);
                        }
                        else {
                            g2d.drawArc(X - width, Y - height, width * 2, height * 2, 0, -90);
                            g2d.setColor(Color.green);
                            int l = 8;
                            int abx = (int)((double)(ax - bx + (width/2)) / d * l);
                            int aby = (int)((double)(ay - by + (width/2)) / d * l);
                            int abx1 = aby;
                            int aby1 = -abx;
                            g.drawPolygon(new int [] {bx, bx+abx1+3*abx, bx-abx1+3*abx}, new int [] {by, by+aby1+3*aby, by-aby1+3*aby}, 3);
                            g2d.setColor(Color.black);
                        }
                        //такая же дуга, но в другую сторону:
                        //g2d.setColor(Color.blue);
                        //g2d.drawArc(X, Y, width*2, height*2, 90, 90);
               }
            }
        }
    }

    private double getAngle(int x2, int y2, int x1, int y1) {
        return Math.atan2(y1 - y2, x2 - x1);
    }
}
