package gui;

import graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphVisualizer implements AlgorithmVisualizer {
    private Graph graph;
    private int n;
    private int r;

    GraphVisualizer(Graph graph) {
        this.graph = graph;
        n = graph.getVerticesCount();
        r = 200;
    }

//    @Override
//    public void paint(Graphics g, int centerX, int centerY) {
//        Graphics2D g2d = (Graphics2D)g;
//        var verticesCoordinates = getVerticesCoordinates(centerX, centerY);
//        var x = verticesCoordinates.get(0);
//        var y = verticesCoordinates.get(1);
////        var n = graph.getVerticesCount();
////        var r = 300;
////        var centerX = getWidth() / 2;
////        var centerY = getHeight() / 2;
////        var angle = 0.0;
////        var x = new int[n];
////        var y = new int[n];
////        var angles = new double[n];
////        for (var i = 0; i < n; i++) {
////            angle = 2 * Math.PI * i / n;
////            angles[i] = angle;
////            x[i] = (int)Math.round(r * Math.cos(angle) + centerX);
////            y[i] = (int)Math.round(r * Math.sin(angle) + centerY);
////            g.setColor(Color.BLACK);
////            g.fillOval(x[i] - 4, y[i] - 8, 16, 16);
////            g.setColor(Color.red);
////            g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));
////            g.drawString(i+"", x[i] - 16, y[i] + 16);
////            g.setColor(Color.black);
////        }
//        var adjacencyMatrix = graph.getAdjacencyMatrix();
//        for (var i = 0; i < n; i++) {
//            for (var j = i+1; j < n; j++) {
//                if (adjacencyMatrix[i][j]) {
//                    int d = (int) Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
//                    int ax = x[i];
//                    int ay = y[i];
//                    int bx = x[j];
//                    int by = y[j];
//                    int deltaX = bx - ax;
//                    int deltaY = by - ay;
//                    int X = Math.min(ax, bx);
//                    int Y = Math.min(ay, by);
//                    int width = Math.abs(ax - bx);
//                    int height = Math.abs(ay - by);
//                    if (deltaX == 0 || deltaY == 0){
//                        if (deltaX == 0){
//                            width = d/4;
//                            height = d;
//                            g2d.drawArc(X - width/2, Y, width, height, 90, 180);
//                            g2d.setColor(Color.green);
//                            int l = 8;
//                            int abx = (int)((double)(-bx + ax + (width*8)) / d * l/4);
//                            int aby = (int)((double)(-by + ay - (width*8))/ d * l/4);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int [] {bx, bx-abx1-3*abx, bx+abx1-3*abx}, new int [] {by, by-aby1-3*aby, by+aby1-3*aby}, 3);
//                        }
//                        else
//                        {
//                            width = d;
//                            height = d/4;
//                            g2d.drawArc(X, Y - height/2, width, height, 0, 180);
//                            g2d.setColor(Color.green);
//                            int l = 8;
//                            int abx = (int)((double)(bx - ax + (height*8)) / d * l/4);
//                            int aby = (int)((double)(by - ay - (height*8))/ d * l/4);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int [] {bx, bx-abx1+3*abx, bx+abx1+3*abx}, new int [] {by, by-aby1+3*aby, by+aby1+3*aby}, 3);
//                        }
//                        g2d.setColor(Color.black);
//                    }
//                    else {
//                        if (deltaX < 0 && deltaY < 0 || deltaX > 0 && deltaY > 0) {
//                            g2d.drawArc(X - width, Y, width * 2, height * 2, 0, 90);
//                            g2d.setColor(Color.green);
//                            int l = 4;
//                            int abx = (int) ((double) (-bx + ax + (width / 2)) / d * l);
//                            int aby = (int) ((double) (-by + ay - (width / 2)) / d * l);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int[]{bx, bx - abx1 + 3 * abx, bx + abx1 + 3 * abx}, new int[]{by, by - aby1 + 3 * aby, by + aby1 + 3 * aby}, 3);
//                            g2d.setColor(Color.black);
//                        } else {
//                            g2d.drawArc(X - width, Y - height, width * 2, height * 2, 0, -90);
//                            g2d.setColor(Color.green);
//                            int l = 4;
//                            int abx = (int) ((double) (ax - bx + (width / 2)) / d * l);
//                            int aby = (int) ((double) (ay - by + (width / 2)) / d * l);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int[]{bx, bx + abx1 + 3 * abx, bx - abx1 + 3 * abx}, new int[]{by, by + aby1 + 3 * aby, by - aby1 + 3 * aby}, 3);
//                            g2d.setColor(Color.black);
//                        }
//                    }
//                }
//                if (adjacencyMatrix[j][i])
//                {
//                    int d = (int) Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
//                    int ax = x[j];
//                    int ay = y[j];
//                    int bx = x[i];
//                    int by = y[i];
//                    int deltaX = bx - ax;
//                    int deltaY = by - ay;
//                    int X = Math.min(ax, bx);
//                    int Y = Math.min(ay, by);
//                    int width = Math.abs(ax - bx);
//                    int height = Math.abs(ay - by);
//                    if (deltaX == 0 || deltaY == 0) {
//                        if (deltaX == 0) {
//                            width = d/4;
//                            height = d;
//                            g2d.drawArc(X - width/2, Y, width, height, -90, 180);
//                            g2d.setColor(Color.green);
//                            int l = 8;
//                            int abx = (int)((double)(bx - ax + (width*8)) / d * l/4);
//                            int aby = (int)((double)(by - ay - (width*8))/ d * l/4);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int [] {bx, bx-abx1+3*abx, bx+abx1+3*abx}, new int [] {by, by-aby1+3*aby, by+aby1+3*aby}, 3);
//                        }
//                        else {
//                            width = d;
//                            height = d/4;
//                            g2d.drawArc(X, Y - height/2, width, height, 180, 180);
//                            g2d.setColor(Color.green);
//                            int l = 8;
//                            int abx = (int)((double)(-bx + ax + (height*8)) / d * l/4);
//                            int aby = (int)((double)(-by + ay - (height*8))/ d * l/4);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int [] {bx, bx-abx1-3*abx, bx+abx1-3*abx}, new int [] {by, by-aby1-3*aby, by+aby1-3*aby}, 3);
//                        }
//                        g2d.setColor(Color.black);
//                    }
//                    else {
//                        if (deltaX < 0 && deltaY < 0 || deltaX > 0 && deltaY > 0) {
//                            g2d.drawArc(X, Y - height, width * 2, height * 2, 180, 90);
//                            g2d.setColor(Color.green);
//                            int l = 4;
//                            int abx = (int) ((double) (bx - ax + (width / 2)) / d * l);
//                            int aby = (int) ((double) (by - ay - (width / 2)) / d * l);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int[]{bx, bx - abx1 - 3 * abx, bx + abx1 - 3 * abx}, new int[]{by, by - aby1 - 3 * aby, by + aby1 - 3 * aby}, 3);
//                            g2d.setColor(Color.black);
//                        }
//                        else {
//                            g2d.drawArc(X, Y, width * 2, height * 2, 90, 90);
//                            g2d.setColor(Color.green);
//                            int l = 4;
//                            int abx = (int) ((double) (-ax + bx + (width / 2)) / d * l);
//                            int aby = (int) ((double) (-ay + by + (width / 2)) / d * l);
//                            int abx1 = aby;
//                            int aby1 = -abx;
//                            g.fillPolygon(new int[]{bx, bx + abx1 - 3 * abx, bx - abx1 - 3 * abx}, new int[]{by, by + aby1 - 3 * aby, by - aby1 - 3 * aby}, 3);
//                            g2d.setColor(Color.black);
//                        }
//                    }
//                }
//            }
//        }
//    }

    ArrayList<Integer[]> getVerticesCoordinates(int centerX, int centerY) {
        var angle = 0.0;
        var x = new Integer[n];
        var y = new Integer[n];
        for (var i = 0; i < n; i++) {
            angle = 2 * Math.PI * i / n;
            x[i] = (int) Math.round(r * Math.cos(angle) + centerX);
            y[i] = (int) Math.round(r * Math.sin(angle) + centerY);
        }
        var result = new ArrayList<Integer[]>();
        result.add(x);
        result.add(y);
        return result;
    }

    private void paintVertex(Graphics2D g, int x, int y, Color vertexColor) {
        g.setColor(vertexColor);
        g.fillOval(x - 4, y - 8, 16, 16);
    }

    private void paintNumberOfVertex(Graphics2D g, int x, int y, int i, Color color) {
        g.setColor(color);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString(i + "", x - 16, y + 16);
    }

    @Override
    public void paint(Graphics g, int centerX, int centerY) {
        Graphics2D g2d = (Graphics2D) g;
        var verticesCoordinates = getVerticesCoordinates(centerX, centerY);
        var x = verticesCoordinates.get(0);
        var y = verticesCoordinates.get(1);
        for (var i = 0; i < n; i++) {
            paintVertex(g2d, x[i], y[i], Color.BLACK);
        }
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        for (var i = 0; i < n; i++) {
            for (var j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    paintEdgeAsPro(g2d, x[i], y[i], x[j], y[j], false, Color.BLACK);
                }
                if (adjacencyMatrix[j][i]) {
                    paintEdgeAsPro(g2d, x[j], y[j], x[i], y[i], true, Color.BLACK);
                }
            }
        }
        for (var k = 0; k < n; k++) {
            paintNumberOfVertex(g2d, x[k], y[k], k, Color.magenta);
        }
    }

    void paintEdgeAsPro(Graphics2D g2d, int x1, int y1, int x2, int y2, boolean reversed, Color color){
        int d = (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        int ax = x1;
        int ay = y1;
        int bx = x2;
        int by = y2;
        int deltaX = bx - ax;
        int deltaY = by - ay;
        int X = Math.min(ax, bx);
        int Y = Math.min(ay, by);
        int width = Math.abs(ax - bx);
        int height = Math.abs(ay - by);
        g2d.setColor(color);
        int sign = reversed ? -1 : 1;
        if (deltaX == 0 || deltaY == 0) {
            if (deltaX == 0) {
                width = d / 4;
                height = d;
                g2d.drawArc(X - width / 2, Y, width, height, 90 * sign, 180);
                int l = 6;
                int abx = (int) ((double) (-bx*sign + ax*sign + (width * 8)) / d * l / 4);
                int aby = (int) ((double) (-by*sign + ay*sign - (width * 8)) / d * l / 4);
                int abx1 = aby;
                int aby1 = -abx;
                g2d.fillPolygon(new int[]{bx, bx - abx1 - 3 * abx * sign, bx + abx1 - 3 * abx * sign}, new int[]{by, by - aby1 - 3 * aby * sign, by + aby1 - 3 * aby * sign}, 3);
            } else {
                width = d;
                height = d / 4;
                g2d.drawArc(X, Y - height / 2, width, height, reversed ? 180 : 0, 180);
                int l = 6;
                int abx = (int) ((double) (bx * sign - ax * sign + (height * 8)) / d * l / 4);
                int aby = (int) ((double) (by * sign - ay * sign - (height * 8)) / d * l / 4);
                int abx1 = aby;
                int aby1 = -abx;
                g2d.fillPolygon(new int[]{bx, bx - abx1 + 3 * abx * sign, bx + abx1 + 3 * abx * sign}, new int[]{by, by - aby1 + 3 * aby * sign, by + aby1 + 3 * aby * sign}, 3);
            }
        } else {
            if (deltaX < 0 && deltaY < 0 || deltaX > 0 && deltaY > 0) {
                g2d.drawArc(X - (reversed ? 0 : width), Y - (reversed ? height : 0), width * 2, height * 2, reversed ? 180 : 0, 90);
                int l = 6;
                int abx = (int) ((double) (-bx * sign + ax * sign + (width / 2)) / d * l);
                int aby = (int) ((double) (-by * sign + ay * sign - (width / 2)) / d * l);
                int abx1 = aby;
                int aby1 = -abx;
                g2d.fillPolygon(new int[]{bx, bx - abx1 + 3 * abx * sign, bx + abx1 + 3 * abx * sign}, new int[]{by, by - aby1 + 3 * aby * sign, by + aby1 + 3 * aby * sign}, 3);
            } else {
                g2d.drawArc(X - (reversed ? 0 : width), Y - (reversed ? 0 : height), width * 2, height * 2, reversed ? 180 : 0, -90);
                int l = 6;
                int abx = (int) ((double) (ax * sign - bx * sign + (width / 2)) / d * l);
                int aby = (int) ((double) (ay * sign - by * sign + (width / 2)) / d * l);
                int abx1 = aby;
                int aby1 = -abx;
                g2d.fillPolygon(new int[]{bx, bx + abx1 + 3 * abx * sign, bx - abx1 + 3 * abx * sign}, new int[]{by, by + aby1 + 3 * aby * sign, by - aby1 + 3 * aby * sign}, 3);
            }
        }
    }
}
