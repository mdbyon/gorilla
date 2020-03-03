package com.byon.gorilla.algorithms;

public class WiggleSubsequence {

    //Input: [1,7,4,9,2,5]
    //Output: 6


    //Input: [1,17,5,10,13,15,10,5,16,8]
    //Output: 7

    //Input: [1,2,3,4,5,6,7,8,9]
    //Output: 2

    //rec(index + 1, increasing), rec(index + 1)

    //if increasing and curr is not -> index + 1

    public static int getWiggleSubsequence(int [] nums, int index, boolean increasing, int prev){
        if(index == nums.length){
            return 0;
        }

        if(increasing && nums[index] > prev){
            return Math.max(
                    1 + getWiggleSubsequence(nums, index + 1, false, nums[index]),
                    getWiggleSubsequence(nums, index + 1, true, prev));
        }

        if(!increasing && nums[index] < prev){
            return Math.max(
                    1 + getWiggleSubsequence(nums, index + 1, true, nums[index]),
                    getWiggleSubsequence(nums, index + 1, false, prev));
        }

        return getWiggleSubsequence(nums, index + 1, increasing, prev);



    }
//
//    public static int getWiggleSubsequenceDP(int [] nums, int index, boolean increasing, int prev){
//        int [] dp = new int
//
//    }

    public static void main(String [] args){
        System.out.println(getWiggleSubsequence(new int[]{1,7,4,9,2,5}, 0, true, Integer.MIN_VALUE));
        System.out.println(getWiggleSubsequence(new int[]{1,7,4,9,2,5}, 0, false, Integer.MAX_VALUE));
    }

}
