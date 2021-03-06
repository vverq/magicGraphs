package gui;

import graph.Graph;

import java.awt.*;
import javax.swing.*;


class MainApplicationFrame extends JFrame {
    private GifCreator gifCreator;
    private Visualizer visualizer;
    MainApplicationFrame(Graph graph, IAlgorithmVisualizer algorithmVisualizer, String gifname) {
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(750,600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("MagicGraphs");
        gifCreator = new GifCreator(gifname);
        visualizer = new Visualizer(algorithmVisualizer);
        visualizer.support.addPropertyChangeListener(gifCreator);
        visualizer.start();
        this.getContentPane().add(visualizer);
    }

    @Override
    public void dispose() {
        System.out.println("(99");
        gifCreator.createGif();
        visualizer.support.removePropertyChangeListener(gifCreator);
        System.exit(0);
    }
}
