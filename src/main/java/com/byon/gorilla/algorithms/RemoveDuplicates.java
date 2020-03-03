package com.byon.gorilla.algorithms;

import java.util.*;

public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        char[] letters = s.toCharArray();

        StringBuilder result = new StringBuilder();
        Map<Integer, Character> map = new HashMap();
        map.put(0, letters[0]);
        Set<Integer> deleted = new HashSet();

        int windowSize = 1;

        for (int i = 1; i < letters.length; i++) {

            if (letters[i] == letters[i - 1]) {
                deleted.add(i);
                deleted.add(i - 1);
                windowSize+=2;

            } else if (i - windowSize >= 0 && map.get(i - windowSize) == letters[i]) {
                deleted.add(i);
                deleted.add(i - windowSize);
                windowSize+=2;
            } else {
                windowSize = 1;
            }
            map.put(i, letters[i]);
        }


        for (int i = 0; i < s.length(); i++) {
            if(!deleted.contains(i)){
                result.append(letters[i]);
            }
        }

        return result.toString();
    }

    public static void main(String [] args){
        System.out.println(removeDuplicates("abbaca"));
    }
}
