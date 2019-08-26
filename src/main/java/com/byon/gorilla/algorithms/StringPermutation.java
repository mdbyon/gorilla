package com.byon.gorilla.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {

    Set<String> set = new HashSet<String>();
    public int numTilePossibilities(String tiles) {
        //for every letter in word, call permute starting at index 0
        for(int i = 0; i< tiles.length(); i++) {
            permute(tiles, 0, i, new StringBuilder());
        }
        return set.size();
    }

    public void permute(String word, int index, int startingChar, StringBuilder sb){

        if(index == word.length()){
            set.add(sb.toString());
        }
        for(int i = startingChar; i<word.length(); i++){
            int deleteIndex;
                if(i != startingChar){
                    deleteIndex = i;
                    sb.append(word.charAt(index));
                } else{
                    deleteIndex = startingChar;
                    sb.append(word.charAt(startingChar));
                }
                    permute(word, i + 1 , startingChar, sb);
                    sb.deleteCharAt(deleteIndex);
            }
        }
    }

