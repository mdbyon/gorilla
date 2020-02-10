package com.byon.gorilla.algorithms;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int []  nums){

        Arrays.sort(nums);

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        HashSet<Integer> resultSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList();

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> currList = map.get(nums[i]);
                currList.add(i);
                map.put(nums[i], currList);
            }
            else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(nums[i], indices);
            }
        }

        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int currTotal = nums[i] + nums[j];

                if(map.containsKey(currTotal * -1) ){
                    if(map.get(currTotal * -1).get(map.get(currTotal * -1).size() - 1) > j){
                        int thirdNum = map.get(currTotal * - 1).size() - 1;
                        int key = nums[i] * 100 + nums[j] * 10 + nums[thirdNum];
                        if(!resultSet.contains(key)) {
                            List<Integer> addedResult = new ArrayList<>();
                            addedResult.add(nums[i]);
                            addedResult.add(nums[j]);
                            addedResult.add(nums[thirdNum]);
                            result.add(addedResult);
                        }


                    }
                }
            }
        }

        return result;

    }
}
