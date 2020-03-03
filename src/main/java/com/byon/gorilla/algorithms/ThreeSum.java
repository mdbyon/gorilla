package com.byon.gorilla.algorithms;

import java.util.*;

public class ThreeSum {

    public static int findBestValue(int[] arr, int target) {

        if(arr.length == 0) return 0;
        Arrays.sort(arr);
        int sum = 0;

        for(int i = 0; i<arr.length; i++){
            sum+= arr[i];
        }

        if(sum <= target){
            System.out.println("dfdf");
            return arr[arr.length - 1];
        }

        int result = 0;
        int actualSum = 0;
        int diff = Integer.MAX_VALUE;

        int tail = 0;

        for(int i = 0; i<arr.length; i++){

            int curr = (arr[i] * (arr.length - i)) + tail;
            System.out.println(curr);

            if(arr[i] > Math.round((float)target/arr.length - i)
                    && target - Math.round((float)target/arr.length - i) + tail <= diff){
                return Math.round((float)target/(arr.length - i));
            }

            if(Math.abs(target - curr) < diff){
                diff = target - curr;
                System.out.println("dfdf");
                result = arr[i];

            }
            tail += arr[i];


        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(findBestValue(new int[] {1547,83230,57084,93444,70879}, 71237));
    }
}
