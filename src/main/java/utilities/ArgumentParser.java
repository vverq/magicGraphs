package utilities;

import java.util.HashMap;

public class ArgumentParser {
    public static HashMap<String, String> parseArguments(String[] args)
    {
        HashMap<String, String> arguments = new HashMap<>();
        if (args[0].equals("directed")) {
            arguments.put("type", "directed");
        }
        else if (args[0].equals("undirected")) {
            arguments.put("type", "undirected");
        }
        else {
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
        if (args[2].equals("DFS") || args[2].equals("BFS")) {
            arguments.put("algorithms", args[2]);
        }
        else {
            System.out.println("Now you can choose only two algorithms: <DFS> or <BFS>");
            System.exit(3);
        }
        return arguments;
    }
}
