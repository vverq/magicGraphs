package gui;

import graph.Graph;

import java.awt.*;
import javax.swing.*;


public class MainApplicationFrame extends JFrame
{
    MainApplicationFrame(Graph graph)
    {
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(750,600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MagicGraphs");
        var visualizer = new GraphVisualizer(graph);
        this.getContentPane().add(visualizer);
    }


}
