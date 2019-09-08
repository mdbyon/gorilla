package com.byon.gorilla.algorithms;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){

            if(curr > 0){
                curr += nums[i];
            }
            else{
                curr = nums[i];
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
