package com.byon.gorilla.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCharacters {

    Map<Character, Integer> map = new HashMap();

    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }

        for (String word : words) {

            Map<Character, Integer> temp = new HashMap();

            for (int i = 0; i < word.length(); i++) {
                temp.put(word.charAt(i), temp.getOrDefault(word.charAt(i), 0) + 1);
            }
            if (isSubSet(temp)) result += word.length();
        }
        return result;
    }


    public boolean isSubSet(Map<Character, Integer> subset) {
        for (Character key : subset.keySet()) {
            if (!map.containsKey(key) || map.get(key) < subset.get(key)) return false;
        }
        return true;
    }
}
