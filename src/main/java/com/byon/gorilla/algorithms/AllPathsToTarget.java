package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;

public class AllPathsToTarget {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        walk(graph, new ArrayList<>(), 0);
        return result;

    }

    public void walk(int [][] graph, List<Integer> path, int node){


        if(node == graph.length - 1) {
            List<Integer> currResult = new ArrayList<>(path);
            currResult.add(graph.length - 1);
            result.add(currResult);
            return;
        }

        path.add(node);

        for(int i = 0; i<graph[node].length; i++){
            walk(graph, path, graph[node][i]);
        }

        path.remove(path.size() - 1);
    }


    public static void main(String [] args){
        AllPathsToTarget runner = new AllPathsToTarget();
       List<List<Integer>> res = runner.allPathsSourceTarget(new int[][]{ {1,2}, {3}, {3}, {}});
       System.out.println(res.size());
    }
}
