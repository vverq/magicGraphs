package gui;

import graph.DirectedGraph;
import graph.Graph;
import graph.UndirectedGraph;
import utilities.Reader;
import utilities.ArgumentParser;

import java.awt.Frame;
import java.io.File;
import java.util.HashMap;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Program {

    public static void main(String[] args) {
        HashMap<String, String> arguments = ArgumentParser.parseArguments(args);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            Reader reader = new Reader();
            Graph graph;
            var result = reader.readFile(new File("./" + arguments.get("filename")));
            if (arguments.get("type").equals("directed")) {
                graph = new DirectedGraph((boolean[][])result.get(0));
            }
            else {
                graph = new UndirectedGraph((boolean[][])result.get(0));
            }
            graph.setWeightMatrix((int[][])result.get(1));
            AlgorithmVisualizer algorithmVisualizer;
            if (arguments.get("algorithms").equals("DFS"))
                algorithmVisualizer = new DFSVisualizer(graph);
            else
                algorithmVisualizer = new GraphVisualizer(graph);
            MainApplicationFrame frame = new MainApplicationFrame(graph, algorithmVisualizer);
            frame.pack();
            frame.setVisible(true);
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
      });
    }
}
