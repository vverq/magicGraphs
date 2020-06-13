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
            for (var j = i+1; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                        int d = (int) Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
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
                        if (deltaX == 0 || deltaY == 0){
                            if (deltaX == 0){
                                width = d/4;
                                height = d;
                                g2d.drawArc(X - width/2, Y, width, height, 90, 180);
                                g2d.setColor(Color.green);
                                int l = 8;
                                int abx = (int)((double)(-bx + ax + (width*8)) / d * l/4);
                                int aby = (int)((double)(-by + ay - (width*8))/ d * l/4);
                                int abx1 = aby;
                                int aby1 = -abx;
                                g.fillPolygon(new int [] {bx, bx-abx1-3*abx, bx+abx1-3*abx}, new int [] {by, by-aby1-3*aby, by+aby1-3*aby}, 3);
                            }
                            else
                            {
                                width = d;
                                height = d/4;
                                g2d.drawArc(X, Y - height/2, width, height, 0, 180);
                                g2d.setColor(Color.green);
                                int l = 8;
                                int abx = (int)((double)(bx - ax + (height*8)) / d * l/4);
                                int aby = (int)((double)(by - ay - (height*8))/ d * l/4);
                                int abx1 = aby;
                                int aby1 = -abx;
                                g.fillPolygon(new int [] {bx, bx-abx1+3*abx, bx+abx1+3*abx}, new int [] {by, by-aby1+3*aby, by+aby1+3*aby}, 3);
                            }
                            g2d.setColor(Color.black);
                        }
                        else {
                            if (deltaX < 0 && deltaY < 0 || deltaX > 0 && deltaY > 0) {
                                g2d.drawArc(X - width, Y, width * 2, height * 2, 0, 90);
                                g2d.setColor(Color.green);
                                int l = 4;
                                int abx = (int) ((double) (-bx + ax + (width / 2)) / d * l);
                                int aby = (int) ((double) (-by + ay - (width / 2)) / d * l);
                                int abx1 = aby;
                                int aby1 = -abx;
                                g.fillPolygon(new int[]{bx, bx - abx1 + 3 * abx, bx + abx1 + 3 * abx}, new int[]{by, by - aby1 + 3 * aby, by + aby1 + 3 * aby}, 3);
                                g2d.setColor(Color.black);
                            } else {
                                g2d.drawArc(X - width, Y - height, width * 2, height * 2, 0, -90);
                                g2d.setColor(Color.green);
                                int l = 4;
                                int abx = (int) ((double) (ax - bx + (width / 2)) / d * l);
                                int aby = (int) ((double) (ay - by + (width / 2)) / d * l);
                                int abx1 = aby;
                                int aby1 = -abx;
                                g.fillPolygon(new int[]{bx, bx + abx1 + 3 * abx, bx - abx1 + 3 * abx}, new int[]{by, by + aby1 + 3 * aby, by - aby1 + 3 * aby}, 3);
                                g2d.setColor(Color.black);
                            }
                        }
               }
                if (adjacencyMatrix[j][i])
                {
                    int d = (int) Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
                    int ax = x[j];
                    int ay = y[j];
                    int bx = x[i];
                    int by = y[i];
                    int deltaX = bx - ax;
                    int deltaY = by - ay;
                    int X = Math.min(ax, bx);
                    int Y = Math.min(ay, by);
                    int width = Math.abs(ax - bx);
                    int height = Math.abs(ay - by);
                    if (deltaX == 0 || deltaY == 0) {
                        if (deltaX == 0) {
                            width = d/4;
                            height = d;
                            g2d.drawArc(X - width/2, Y, width, height, -90, 180);
                            g2d.setColor(Color.green);
                            int l = 8;
                            int abx = (int)((double)(bx - ax + (width*8)) / d * l/4);
                            int aby = (int)((double)(by - ay - (width*8))/ d * l/4);
                            int abx1 = aby;
                            int aby1 = -abx;
                            g.fillPolygon(new int [] {bx, bx-abx1+3*abx, bx+abx1+3*abx}, new int [] {by, by-aby1+3*aby, by+aby1+3*aby}, 3);
                        }
                        else {
                            width = d;
                            height = d/4;
                            g2d.drawArc(X, Y - height/2, width, height, 180, 180);
                            g2d.setColor(Color.green);
                            int l = 8;
                            int abx = (int)((double)(-bx + ax + (height*8)) / d * l/4);
                            int aby = (int)((double)(-by + ay - (height*8))/ d * l/4);
                            int abx1 = aby;
                            int aby1 = -abx;
                            g.fillPolygon(new int [] {bx, bx-abx1-3*abx, bx+abx1-3*abx}, new int [] {by, by-aby1-3*aby, by+aby1-3*aby}, 3);
                        }
                        g2d.setColor(Color.black);
                    }
                    else {
                        if (deltaX < 0 && deltaY < 0 || deltaX > 0 && deltaY > 0) {
                            g2d.drawArc(X, Y - height, width * 2, height * 2, 180, 90);
                            g2d.setColor(Color.green);
                            int l = 4;
                            int abx = (int) ((double) (bx - ax + (width / 2)) / d * l);
                            int aby = (int) ((double) (by - ay - (width / 2)) / d * l);
                            int abx1 = aby;
                            int aby1 = -abx;
                            g.fillPolygon(new int[]{bx, bx - abx1 - 3 * abx, bx + abx1 - 3 * abx}, new int[]{by, by - aby1 - 3 * aby, by + aby1 - 3 * aby}, 3);
                            g2d.setColor(Color.black);
                        }
                        else {
                            g2d.drawArc(X, Y, width * 2, height * 2, 90, 90);
                            g2d.setColor(Color.green);
                            int l = 4;
                            int abx = (int) ((double) (-ax + bx + (width / 2)) / d * l);
                            int aby = (int) ((double) (-ay + by + (width / 2)) / d * l);
                            int abx1 = aby;
                            int aby1 = -abx;
                            g.fillPolygon(new int[]{bx, bx + abx1 - 3 * abx, bx - abx1 - 3 * abx}, new int[]{by, by + aby1 - 3 * aby, by - aby1 - 3 * aby}, 3);
                            g2d.setColor(Color.black);
                        }
                    }
                }
            }
        }
    }
}
