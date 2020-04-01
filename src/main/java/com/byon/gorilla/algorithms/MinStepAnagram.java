package com.byon.gorilla.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinStepAnagram {

    public static int minSteps(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();


        Arrays.sort(sArray);
        Arrays.sort(tArray);


        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> mapOther = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            mapOther.put(t.charAt(i), mapOther.getOrDefault(t.charAt(i), 0) + 1);
        }

        int result = 0;
        for (Character key : map.keySet()) {
            if (mapOther.containsKey(key)) result += Math.min(map.get(key), mapOther.get(key));
        }

        return Math.max(s.length(), t.length()) - result;


    }

    public static void main(String[] args) {
        System.out.println(minSteps("aba", "bab"));
    }

}
