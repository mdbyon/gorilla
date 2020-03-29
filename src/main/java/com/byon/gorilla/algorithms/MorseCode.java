package com.byon.gorilla.algorithms;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {


    String [] map = new String[26];

    public int uniqueMorseRepresentations(String[] words) {
        //for each word generate its transformation
        //add transformation to set
        //return set size
        Set<String> set = new HashSet();
        generateMappings();

        for(String word : words){

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i<word.length(); i++){
                sb.append(map[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();


    }

    private void generateMappings(){

        String [] words = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for(int i = 0; i<26;i++){
            map[i] = words[i];
        }
    }

}
