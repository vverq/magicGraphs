package utilities;

import java.util.HashMap;

public class ArgumentParser {
    enum typeGraph {
        directed,
        undirected
    }

    public enum algorithms{
        DFS,
        BFS
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
            System.out.println("Now you can choose only two algorithms: <DFS> or <BFS>");
            System.exit(3);
        }
        try {
            arguments.put("gifname", args[3]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Input name for gif-file");
            System.exit(4);
        }
        return arguments;
    }
}
