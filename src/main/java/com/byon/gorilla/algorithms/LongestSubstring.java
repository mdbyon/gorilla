package com.byon.gorilla.algorithms;

import java.util.HashSet;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> currWindow = new HashSet<Character>();

        if (s == null || s.length() == 0) return maxLength;

        if (s.length() == 1) return 1;

        int p1 = 0;
        int p2 = 1;
        currWindow.add(s.charAt(p1));

        while (p2 < s.length()) {
            if (currWindow.contains(s.charAt(p2))) {
                while (s.charAt(p1) != s.charAt(p2)) {
                    currWindow.remove(s.charAt(p1));
                    p1++;
                }
                currWindow.remove(s.charAt(p1));
                p1++;
            } else {
                currWindow.add(s.charAt(p2));
                p2++;
            }
            maxLength = Math.max(maxLength, p2 - p1);
        }
        return maxLength;
    }
}
