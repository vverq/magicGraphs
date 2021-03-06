package utilities;

import java.util.HashMap;

public class ArgumentParser {
    enum typeGraph {
        directed,
        undirected
    }

    public enum algorithms{
        DFS,
        BFS,
        Dijkstra,
        BellmanFord,
        MAXMINPath
    }

    public static HashMap<String, String> parseArguments(String[] args) {
        HashMap<String, String> arguments = new HashMap<>();
        try {
            arguments.put("type", typeGraph.valueOf(args[0]).toString());
        } catch (IllegalArgumentException ex) {
            System.out.println("Please, check examples in README.md: " +
                    "there are only two modes (<directed> and <undirected>)");
            System.exit(1);
        }
        String filename = args[1];
        if (filename.lastIndexOf(".") != -1 && filename.lastIndexOf(".") != 0) {
            if (filename.substring(filename.lastIndexOf(".") + 1).equals("txt")) {
                arguments.put("filename", filename);
            }
            else {
                System.out.println("Input txt-file name");
                System.exit(2);
            }
        }
        try {
            arguments.put("algorithms", algorithms.valueOf(args[2]).toString());
        } catch (IllegalArgumentException ex) {
            System.out.println("Now you can choose only five algorithms: <DFS>, <BFS>, <Dijkstra>, <BellmanFord> " +
                    "or <MAXMINPath>");
            System.exit(3);
        }
        // todo: тупо сделано
        try {
            arguments.put("source", args[3]);
            if (arguments.get("algorithms").equals("Dijkstra") ||
                    arguments.get("algorithms").equals("BellmanFord") ||
                    arguments.get("algorithms").equals("MAXMINPath")) {
                arguments.put("destination", args[4]);
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Input <source> and (if its necessary) <destination> params");
            System.exit(4);
        }
        try {
            if (arguments.get("algorithms").equals("Dijkstra") ||
                    arguments.get("algorithms").equals("BellmanFord") ||
                    arguments.get("algorithms").equals("MAXMINPath")) {
                arguments.put("gifname", args[5]);
            }
            else {
                arguments.put("gifname", args[4]);
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Input name for gif-file");
            System.exit(5);
        }
        return arguments;
    }
}
