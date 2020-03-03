package com.byon.gorilla.algorithms;

public class XOfKindInDeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {

        int currGCD = deck[0];

        for(int i = 0; i<deck.length; i++){
            currGCD = GCD(currGCD, deck[i]);

            if(currGCD == -1) return false;
        }

        return true;
    }

    public int GCD(int currGCD, int target){

        for(int i = currGCD; i > 1; i--){
            if(target % i == 0) return i;
        }
        return -1;
    }
}
