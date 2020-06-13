package gui;

import graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraphVisualizer implements AlgorithmVisualizer {
    private Graph graph;
    private int n;
    private int r;

    GraphVisualizer(Graph graph) {
        this.graph = graph;
        n = graph.getVerticesCount();
        r = 300;
    }

    ArrayList<Integer[]> getVerticesCoordinates(int centerX, int centerY) {
        var angle = 0.0;
        var x = new Integer[n];
        var y = new Integer[n];
        for (var i = 0; i < n; i++) {
            angle = 2 * Math.PI * i / n;
            x[i] = (int)Math.round(r * Math.cos(angle) + centerX);
            y[i] = (int)Math.round(r * Math.sin(angle) + centerY);
        }
        var result = new ArrayList<Integer[]>();
        result.add(x);
        result.add(y);
        return result;
    }

    private void paintVertex(Graphics2D g, int x, int y, int i, Color vertexColor) {
        g.setColor(vertexColor);
        g.fillOval(x - 4, y - 8, 16, 16);
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));
        g.drawString(i + "", x - 16, y + 16);
        g.setColor(Color.black);
    }

    protected void paintEdge(Graphics2D g, int x1, int y1,
                           int x2, int y2, Color edgeColor, Color arrowColor) {
        g.setStroke(new BasicStroke(3.0f));
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
        if (deltaX == 0 || deltaY == 0){
            if (deltaX == 0){
                g.setColor(edgeColor);
                width = d/4;
                height = d;
                g.drawArc(X - width/2, Y, width, height, 90, 180);
                g.setColor(arrowColor);
                int l = 8;
                int abx = (int)((double)(-bx + ax + (width*8)) / d * l/4);
                int aby = (int)((double)(-by + ay - (width*8))/ d * l/4);
                int abx1 = aby;
                int aby1 = -abx;
                g.fillPolygon(new int [] {bx, bx-abx1-3*abx, bx+abx1-3*abx}, new int [] {by, by-aby1-3*aby, by+aby1-3*aby}, 3);
            }
            else
            {
                g.setColor(edgeColor);
                width = d;
                height = d/4;
                g.drawArc(X, Y - height/2, width, height, 0, 180);
                g.setColor(arrowColor);
                int l = 8;
                int abx = (int)((double)(bx - ax + (height*8)) / d * l/4);
                int aby = (int)((double)(by - ay - (height*8))/ d * l/4);
                int abx1 = aby;
                int aby1 = -abx;
                g.fillPolygon(new int [] {bx, bx-abx1+3*abx, bx+abx1+3*abx}, new int [] {by, by-aby1+3*aby, by+aby1+3*aby}, 3);
            }
            g.setColor(Color.black);
        }
        else {
            if (deltaX < 0 && deltaY < 0 || deltaX > 0 && deltaY > 0) {
                g.setColor(edgeColor);
                g.drawArc(X - width, Y, width * 2, height * 2, 0, 90);
                g.setColor(arrowColor);
                int l = 4;
                int abx = (int) ((double) (-bx + ax + (width / 2)) / d * l);
                int aby = (int) ((double) (-by + ay - (width / 2)) / d * l);
                int abx1 = aby;
                int aby1 = -abx;
                g.fillPolygon(new int[]{bx, bx - abx1 + 3 * abx, bx + abx1 + 3 * abx}, new int[]{by, by - aby1 + 3 * aby, by + aby1 + 3 * aby}, 3);
                g.setColor(Color.black);
            } else {
                g.setColor(edgeColor);
                g.drawArc(X - width, Y - height, width * 2, height * 2, 0, -90);
                g.setColor(arrowColor);
                int l = 4;
                int abx = (int) ((double) (ax - bx + (width / 2)) / d * l);
                int aby = (int) ((double) (ay - by + (width / 2)) / d * l);
                int abx1 = aby;
                int aby1 = -abx;
                g.fillPolygon(new int[]{bx, bx + abx1 + 3 * abx, bx - abx1 + 3 * abx}, new int[]{by, by + aby1 + 3 * aby, by - aby1 + 3 * aby}, 3);
                g.setColor(Color.black);
            }
        }
    }

    public void paint(Graphics g, int centerX, int centerY) {
        Graphics2D g2d = (Graphics2D)g;
        var verticesCoordinates = getVerticesCoordinates(centerX, centerY);
        var x = verticesCoordinates.get(0);
        var y = verticesCoordinates.get(1);
        for (var i = 0; i < n; i++) {
            paintVertex(g2d, x[i], y[i], i, Color.BLACK);
        }
        var adjacencyMatrix = graph.getAdjacencyMatrix();
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    paintEdge(g2d, x[i], y[i], x[j], y[j], Color.BLACK, Color.GREEN);
               }
            }
        }
    }

}
