package gui;

import graph.DirectedGraph;
import graph.Graph;
import graph.UndirectedGraph;
import utilities.Reader;
import utilities.ArgumentParser;

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
            IAlgorithmVisualizer algorithmVisualizer;
            // todo тоже тупоо
            if (!arguments.get("algorithms").isEmpty()) {
                if (args.length > 5) {
                    algorithmVisualizer = new AlgorithmVisualizer(
                            graph,
                            arguments.get("algorithms"),
                            Integer.parseInt(arguments.get("source")),
                            Integer.parseInt(arguments.get("destination"))
                    );
                }
                else {
                    algorithmVisualizer = new AlgorithmVisualizer(
                            graph,
                            arguments.get("algorithms"),
                            Integer.parseInt(arguments.get("source"))
                    );
                }
            }
            else {
                algorithmVisualizer = new GraphVisualizer(graph);
            }
            MainApplicationFrame frame = new MainApplicationFrame(graph, algorithmVisualizer, arguments.get("gifname"));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
