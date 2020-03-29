package com.byon.gorilla.algorithms;

import java.util.HashMap;

public class SubarrayDivByK {

    public static int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap();

        int result = 0;
        int cumSum = 0;

        for(int i = 0; i<A.length; i++) {

            cumSum += A[i];

            if (map.containsKey(cumSum % K)) {
                result += map.get(cumSum % K);
            } else if (map.containsKey(cumSum % K * -1)) {
                result += map.get(cumSum % K * -1);
            } else {
                if (cumSum % K == 0) result++;
            }

            map.put(cumSum % K, map.getOrDefault(cumSum % K, 0) + 1);
        }


        return result;
    }

    public static void main(String [] args){
        System.out.println(subarraysDivByK(new int[]{-1,2,9}, 2 ));
    }
}
