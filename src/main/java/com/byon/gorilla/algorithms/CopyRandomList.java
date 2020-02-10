package com.byon.gorilla.algorithms;

import java.util.HashMap;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        HashMap<Integer, Node> getNode = new HashMap();

        if(head == null) return null;

        Node copy = new Node(head.val);
        Node front = copy;
        getNode.put(head.val, copy);

        while(head.next != null){
            if(getNode.containsKey(head.next.val)){
                copy.next = getNode.get(head.next.val);
            }else{
                copy.next = new Node(head.next.val);
                getNode.put(head.next.val, copy.next);
            }

            if(head.random != null){

                if(getNode.containsKey(head.random.val)){
                    copy.random = getNode.get(head.random.val);
                }else{
                    copy.random = new Node(head.random.val);
                    getNode.put(head.random.val, copy.random);
                }
            }
            head = head.next;
            copy = copy.next;
        }

        if(copy.random == null){
            if(head.random != null){
                copy.random = getNode.get(head.random.val);
            }
        }

        return front;
    }

    public static void main(String [] args){
        Node head = new Node(3);
        Node second = new Node(3);
        second.random = head;
        head.next = second;
        Node third = new Node(3);
        second.next= third;

        Node front = copyRandomList(head);
        System.out.println(front.next.val);
    }
}
