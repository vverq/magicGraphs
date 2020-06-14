package gui;

import graph.Graph;

import java.awt.*;
import javax.swing.*;


class MainApplicationFrame extends JFrame {
    MainApplicationFrame(Graph graph, AlgorithmVisualizer algorithmVisualizer) {
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(750,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MagicGraphs");
        var visualizer = new Visualizer(algorithmVisualizer);
        this.getContentPane().add(visualizer);
    }
}
