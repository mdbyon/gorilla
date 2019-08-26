package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RepeatedStringMatch {

    HashMap<Character, List<Node>> map = new HashMap();

    public class Node{
        char val;
        int index;
        Node next;
        boolean isEnd;

        public Node(char val){
            this.val = val;
        }
    }

    public int repeatedStringMatch(String A, String B){
        HashMap<Character, List<Node>> map = new HashMap();
        char [] Aletters = A.toCharArray();
        char [] Bletters = B.toCharArray();
        Node first = new Node(Aletters[0]);
        first.index = 0;
        map.put(Aletters[0], map.getOrDefault(Aletters[0], new ArrayList<Node>(Arrays.asList(first))));
        Node head = first;

        for(int i = 1; i<Aletters.length; i++){
            first.next = new Node(Aletters[i]);
            first.index = i;
            if(map.containsKey(Aletters[i])){
                List<Node> curr = map.get(Aletters[i]);
                curr.add(first.next);
                map.put(Aletters[i], curr);
            } else{
                map.put(Aletters[i], new ArrayList<Node>(Arrays.asList(first.next)));
            }
            first = first.next;
        }
        first.isEnd = true;
        first.next = head;

        List<Node> nodes = map.get(Bletters[0]);
        if(nodes != null){

            for(int i = 0; i< nodes.size();i++){
                if(canContain(nodes.get(i), Bletters)){
                    int dividedBy = Bletters.length / Aletters.length;
                    int offset = nodes.get(i).index;
                    if(offset == 0){
                        return dividedBy;
                    }
                    return dividedBy + 1;
                }
            }
        }
        return -1;

    }

    public boolean canContain(Node A, char [] B) {
        int index = 0;
        for(char letter : B){
            if(A.val == letter){
                A = A.next;
                index++;
            }
        }
        return index == B.length;
    }
}
