package algorithms;

import graph.Graph;

import java.util.Arrays;

public class GraphColoring{
    private boolean isCorrect(int v, boolean graph[][], int color[], int c){
        for (int i = 0; i < graph.length; i++){
            if (graph[v][i] && c == color[i]){
                return false;
            }
        }
        return true;
    }

    private boolean graphColoringUtil(boolean graph[][], int m, int color[], int v){
        if (v == graph.length){
            return true;
        }

        for (int c = 1; c <= m; c++){
            if (isCorrect(v, graph, color, c)){
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1)){
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }

    public int[] graphColoring(Graph graph){
        int V = graph.getVerticesCount();
        boolean[][] matrix = graph.getAdjacencyMatrix();
        int[] color = new int[V];
        for (int i = 0; i < V; i++){
            color[i] = 0;
        }

//        if (!graphColoringUtil(matrix, V, color, 0)){
//            // TODO: кинуть варнинг ноу солюшен
//            System.out.println("Нет решения");
//        }
        return color;
    }

//    public static void main(String[] args)
//    {
//        boolean[][] adjMatrix = {
//                {false, true, false, false},
//                {true, false, true, false},
//                {false, true, false, false},
//                {false, false, false, false}
//        };
//        graph.Graph graph = new graph.Graph(adjMatrix);
//        new algorithms.GraphColoring().graphColoring(graph);
//    }
}