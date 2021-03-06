package com.byon.gorilla.algorithms;

public class HouseRobber {

    public static int rob(int [] nums){

        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        if(nums.length == 1) return nums[0];

        if(nums.length == 0) return 0;

        int [] dp = new int [nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i< nums.length; i++){
            for(int j = 0; j <= i - 2; j++){
                int toRob = nums[i] + dp[j];
                int toNot = dp[i - 1];
                dp[i] = Math.max(dp[i], Math.max(toRob, toNot));
            }
        }

        return dp[nums.length - 1];
    }

}
