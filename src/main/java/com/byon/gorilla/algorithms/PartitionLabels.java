package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    /*
        1.) record last occurrence of each letter in map
        2.) start with idx -> search for end -> anything inside can expand the region
        3.) add to res -> repeat

     */
    public List<Integer> partitionLabels(String S) {

        Map<Character, Integer> map = new HashMap();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), i);
        }

        int idx = 0;

        while(idx < S.length()){

            int expandTo = map.get(S.charAt(idx));
            int curr = idx;

            while(curr <= expandTo){
                expandTo = Math.max(expandTo, map.get(S.charAt(curr)));
                curr++;
            }
            result.add(curr - idx);
            idx = curr;
        }
        return result;
    }
}
