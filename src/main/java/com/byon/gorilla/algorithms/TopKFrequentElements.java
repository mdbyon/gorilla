package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.FrequencyElement;

import java.util.*;

public class TopKFrequentElements{

    public static List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, FrequencyElement> getFrequencyFrequencyElement = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        PriorityQueue<FrequencyElement> minHeap = new PriorityQueue<FrequencyElement>(k);

        if (nums.length == 0) return result;

        for(int num : nums){
            if(getFrequencyFrequencyElement.containsKey(num)){
                FrequencyElement curr = getFrequencyFrequencyElement.get(num);
                curr.frequency++;
                getFrequencyFrequencyElement.put(num, curr);
            } else{
                getFrequencyFrequencyElement.put(num, new FrequencyElement(num, 1));
            }
        }


        for(int key : getFrequencyFrequencyElement.keySet()){
            if(minHeap.size() < k){
                minHeap.add(getFrequencyFrequencyElement.get(key));
            } else if(minHeap.size() == k && minHeap.peek().frequency < getFrequencyFrequencyElement.get(key).frequency) {
                minHeap.poll();
                minHeap.add(getFrequencyFrequencyElement.get(key));
            }

        }

        while (minHeap.peek() != null) {
            result.add(minHeap.poll().val);
        }
        return result;
    }
}
