package com.byon.gorilla.algorithms;

public class SquareRoot {

    public static int calculate(int num){
        int left = 0;
        int right = num;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(num/mid == mid){
                return mid;
            }

            if(mid * mid > num){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String [] args){
        int num = 8;

        System.out.print("answer =======> " + calculate(num));
    }
}