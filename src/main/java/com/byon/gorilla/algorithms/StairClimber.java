package com.byon.gorilla.algorithms;

import java.util.HashMap;

public class StairClimber {

    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
//        return climbStairsTopDown(n, new HashMap<>());
    }

    public int climbStairsTopDown(int n, HashMap<Integer, Integer> memo) {
        if(n == 0){
            return 1;
        }

        if(n < 0) return 0;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        memo.put(n, climbStairs(n - 1) + climbStairs(n-2));

        return memo.get(n);
    }

    public int climbStairsBottomUp(int n){
        int [] lookup = new int[n];

        lookup[0] = 1;
        lookup[1] = 1;

        for(int i = 2; i < n; i++){
            lookup[i] = lookup[i - 1] + lookup[i-2];
        }

        return lookup[n - 1];
    }
}
