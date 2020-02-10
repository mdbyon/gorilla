package com.byon.gorilla.algorithms;

import java.util.*;

class Graph{

    String val;
    List<Graph> neighbors = new ArrayList();
    Graph parent;

    public Graph(String val){
        this.val = val;
    }
}

public class TransformString {

    public static List<String> transformString(Set<String> dict, String s, String t){

       Queue<Graph> queue = new LinkedList();

       dict.remove(s);
       Graph root = new Graph(s);
       queue.offer(root);
       List<String> result = new ArrayList<>();

       while(!queue.isEmpty()){
           Graph curr = queue.poll();

           for(String rem : dict){
               if(differByOne(s, rem)){

                   if(rem.equals(t)){
                       while(curr.val != s){
                           result.add(curr.val);
                           curr = curr.parent;
                       }
                       result.add(t);
                       result.add(0, s);
                   }

                   Graph child = new Graph(rem);
                   queue.offer(child);
                   curr.neighbors.add(child);
                   child.parent = curr;
               }
           }
       }
       return result;
    }

    public static boolean differByOne(String first, String second){
        boolean skip = false;

        if(first == null || second == null || first.length() != second.length()) return false;

        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                if(skip) return false;
                skip = true;
            }
        }
        return true;
    }
}
