package com.byon.gorilla.algorithms;

import java.util.HashMap;

public class CountSubstrings {

    public static int countSubstrings(String s) {

        char [] letters = s.toCharArray();

        HashMap<String, Boolean> map = new HashMap();
        int result = 0;

        for(int i = 0; i<s.length();i++){
            result++;
            map.put(Integer.toString(i) + "," + Integer.toString(i), true);
        }

        for(int i = 1; i<s.length();i++){
            if(letters[i] == letters[i - 1]){
                result++;
                map.put(Integer.toString(i - 1) + "," + Integer.toString(i), true);
            } else{
                map.put(Integer.toString(i - 1) + "," + Integer.toString(i), false);
            }
        }

        for(int size = 3; size<=s.length(); size++){

            for(int i = size - 1; i < s.length(); i++){
                int end = i;
                int start = i - size + 1;
                String key = Integer.toString(start + 1) + "," + Integer.toString(end - 1);
                String replacementKey = Integer.toString(start) + "," + Integer.toString(end);
                if(map.get(key) && letters[start] == letters[end]){
                    System.out.println("got here");
                    result++;
                    map.put(replacementKey, true);
                } else{
                    map.put(replacementKey, false);
                }
                map.remove(key);
            }
        }

        return result;
    }

    public static int rivalCountSubstrings(String s) {

        int sLen = s.length();
        char[] cArr = s.toCharArray();

        int totalPallindromes = 0;

        boolean[][] dp = new boolean[sLen][sLen];

        // Single length pallindroms
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
            totalPallindromes++;
        }

        // 2 length pallindromes
        for (int i = 0; i < sLen - 1; i++) {
            if (cArr[i] == cArr[i + 1]) {
                dp[i][i + 1] = true;
                totalPallindromes++;
            }
        }

        // Lengths > 3

        for (int subLen = 2; subLen < sLen; subLen++) {

            for (int i = 0; i < sLen - subLen; i++) {

                int j = i + subLen;

                if (dp[i + 1][j - 1] && cArr[i] == cArr[j]) {
                    dp[i][j] = true;
                    totalPallindromes++;
                }
            }
        }
        return totalPallindromes;

    }
}
