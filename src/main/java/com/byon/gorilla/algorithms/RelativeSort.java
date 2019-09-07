package com.byon.gorilla.algorithms;

public class RelativeSort {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int [] result = new int[arr1.length];

        for(int i = 0; i< arr1.length; i++){
            map.put(arr1[i], map.containsKey(arr1[i]) ? map.get(arr1[i]) + 1 : 1);
        }

        int index = 0;
        for(int i = 0; i < arr2.length; i++){
            while(map.get(arr2[i]) > 0){
                result[index] = arr2[i];
                map.put(arr2[i], map.get(arr2[i]) - 1);
                index++;
            }
            map.remove(arr2[i]);
        }

        for(Integer key : map.keySet()){
            while(map.get(key) > 0){
                result[index] = key;
                map.put(key, map.get(key) - 1);
                index++;
            }
        }
        return result;
    }
}
