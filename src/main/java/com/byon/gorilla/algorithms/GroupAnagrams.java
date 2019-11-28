package com.byon.gorilla.algorithms;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        for(String word : strs){

            char [] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            if(map.containsKey(key)){
                List<String> currList = map.get(key);
                currList.add(word);
                map.put(key, currList);
            } else{
                map.put(key, new ArrayList<String>(Arrays.asList(word)));
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {

            result.add(entry.getValue());
        }

        return result;
    }

}
