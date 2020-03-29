package com.byon.gorilla.algorithms;

import java.util.HashSet;
import java.util.Set;

public class TilePossibilities {

    //AABCDD
    Set<String> setResult = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        //for every letter in word, call permute starting at index 0

        permute(tiles, new StringBuilder(), new HashSet<Integer>());

        return setResult.size();

    }

    public void permute(String tiles, StringBuilder curr, HashSet<Integer> indicesSeen){

        for(int i = 0; i<tiles.length(); i++){
            if(!indicesSeen.contains(i)){
                curr.append(tiles.charAt(i));
                setResult.add(curr.toString());
                indicesSeen.add(i);

                permute(tiles, curr, indicesSeen);
                indicesSeen.remove(i);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    public static void main(String [] args){
        TilePossibilities runner = new TilePossibilities();
        System.out.println(runner.numTilePossibilities("AAB"));
    }

}
