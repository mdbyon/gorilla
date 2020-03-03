package com.byon.gorilla.algorithms;

import java.util.HashMap;
import java.util.HashSet;

public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        HashSet<Character> keys = new HashSet();
        HashMap<Character, Integer> lastMap = new HashMap();
        int[] map = new int[26];

        for (char task : tasks) {
            keys.add(task);
            map[task - 'A']++;
        }

        int index = 0;
        int result = 0;

        while (keys.size() > 0) {

            for (char key : keys) {
                if (!lastMap.containsKey(key) || index - lastMap.get(key) > n) {
                    lastMap.put(key, index);
                    map[key - 'A']--;
                } else {
                    index++;
                }
                result++;
                if (map[key - 'A'] == 0) keys.remove(key);
            }

        }
        return result;
    }
}
