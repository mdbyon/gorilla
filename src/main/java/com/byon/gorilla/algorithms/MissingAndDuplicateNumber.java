package com.byon.gorilla.algorithms;

public class MissingAndDuplicateNumber {

    public int findDuplicateNumber(int [] nums, int low, int high){
        int result = 0;
        int missingNumber = findMissingNumberGivenDuplicate(nums, low, high);

        for(int j = low; j <= high; j++){
            result ^= j;
        }

        result ^= missingNumber;


        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }

        return result;
    }

    public int findMissingNumberGivenDuplicate(int [] nums, int low, int high){
        int allNumsOR = 0;

        for(int i = 0 ;i < nums.length; i++){
            allNumsOR |= nums[i];
        }

        int curr = allNumsOR;

        for(int j = low; j<= high; j++){
            curr ^= j;
        }

        return curr;
    }

}
