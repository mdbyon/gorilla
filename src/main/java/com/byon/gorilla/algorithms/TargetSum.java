package com.byon.gorilla.algorithms;


public class TargetSum {

    public static int targetSum(int [] nums, int target){
        return targetSumRec(nums, target, 0);
    }

    public static int targetSumRec(int [] nums, int target, int start){

        if(start == nums.length && target == 0) return 1;

        if(start == nums.length) return 0;

        return targetSumRec(nums, target - nums[start], start + 1) +
        targetSumRec(nums, target + nums[start], start + 1);
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int [][] dp = new int[13][nums.length + 1];

        dp[5][nums.length] = 1;

        for(int j = nums.length - 1; j >= 0; j--){
            for(int i = 5; i<= 13; i++){
                dp[i][j] += dp[i - nums[j]][j + 1];
                dp[i][j] += dp[i + nums[j]][j + 1];
            }
        }

        int val = dp[S][0];

        System.out.println("sdf");

        return dp[1000 + S][0];
    }

    public static void main(String [] args){
        System.out.println(findTargetSumWays(new int [] {1, 1, 1, 1, 1}, 3));
    }
}
