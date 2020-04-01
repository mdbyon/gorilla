package com.byon.gorilla.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CardReveal {

    public static int[] deckRevealedIncreasing(int[] deck) {

        if(deck.length <= 1) return deck;

        int [] result = new int[deck.length];

        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList();

        for(int num : deck){
            queue.offer(num);
        }

        int set = 0;

        int revealIdx = 0;

        for(int i = 0; i < deck.length; i+=2){
            result[i] = deck[revealIdx];
            set++;
            revealIdx++;
            queue.poll();
        }

        boolean reveal = false;
        if(deck.length % 2 == 0) reveal = true;
        int idx = 0;

        while(set < deck.length){

            if(idx >= deck.length) {
                idx = 0;
            }
            else if(result[idx] != 0) {
                idx++;
            }
            else{
                if(reveal) {
                    result[idx] = queue.poll();
                    set++;
                }
                reveal = !reveal;
                idx++;
            }

        }

        return result;

    }

    public static void main(String [] args){
        System.out.println(deckRevealedIncreasing(new int[]{1,2,3,4,5,6}));
    }




}
