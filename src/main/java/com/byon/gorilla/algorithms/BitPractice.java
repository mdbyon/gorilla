package com.byon.gorilla.algorithms;

public class BitPractice {

    public static int [] getTwoRightMostBitsThatDiffer(int x){

        int prev = x & 1;
        int prevIndex = 0;
        x >>>= 1;

        while((x & 1) == prev){
            prev = x & 1;
            prevIndex++;
            x >>>= 1;
        }

        return new int[] {prevIndex + 1, prevIndex};
    }

    public static int findClosestWeightNum(int x){

        int[] result = getTwoRightMostBitsThatDiffer(x);

        int first = 1 << result[0];
        int second = 1 << result[1];

        x^=first;
        x^=second;

        return x;
    }

    public static void main(String [] args){
        System.out.println(findClosestWeightNum(4));
    }
}
