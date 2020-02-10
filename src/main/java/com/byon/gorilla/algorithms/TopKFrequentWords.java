package com.byon.gorilla.algorithms;

import java.util.*;

public class TopKFrequentWords {

    HashMap<String, Integer> map = new HashMap();

    class WordComparator implements Comparator<String> {

        @Override
        public int compare(String first, String second) {
            if (map.get(first) < map.get(second)){
                return -1;
            }
            else if(map.get(first) > map.get(second)){
                return 1;
            }
            else if(map.get(first) == map.get(second)){
                if(first.compareTo(second) > 0){
                    return 1;
                } else if(first.compareTo(second) < 0) return -1;
            }
            return 0;
        }
    }


    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue(k, new WordComparator());


        for(String key : map.keySet()){

            if(minHeap.size() < k){
                minHeap.offer(key);
            }

            if(minHeap.size() == k){
                minHeap.poll();
            }
        }

        while(minHeap.size() > 0){
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String [] args){
        TopKFrequentWords runner = new TopKFrequentWords();
        String [] words = new String []{"i" , "love", "i", "leetcode"};
        runner.topKFrequent(words, 2);
    }

}
