package gui;

import graph.DirectedGraph;
import graph.UndirectedGraph;
import tests.Reader;

import java.awt.Frame;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Program
{
    public static void main(String[] args)
    {
      try {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      } catch (Exception e) {
        e.printStackTrace();
      }
      SwingUtilities.invokeLater(() -> {
          Reader reader = new Reader();
          var result = reader.readFile(new File("./in.txt"));
          var graph = new UndirectedGraph((boolean[][])result.get(0));
          graph.setWeightMatrix((int[][])result.get(1));
          MainApplicationFrame frame = new MainApplicationFrame(graph);
          frame.pack();
          frame.setVisible(true);
          frame.setExtendedState(Frame.MAXIMIZED_BOTH);
      });
    }}
