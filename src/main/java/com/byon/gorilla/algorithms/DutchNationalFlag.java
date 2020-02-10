package com.byon.gorilla.algorithms;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class DutchNationalFlag {

    public static void threeWayPartition(int [] nums, int index){

        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        //maintain left////
        //if left < nums[index] left++;
        int pivot = nums[index];

        while(mid < right){
            //if nums[mid] < pivot swap with nums[left] and left++ mid++
            // nums[mid] == pivot mid++;
            //while nums[mid] > pivot swap with nums[right]; right--

            if(nums[mid] < pivot) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if(nums[mid] == pivot){
                mid++;
            } else{
                swap(nums, mid, right);
                right--;
            }
        }
    }

    public static void main(String [] args){
        int []  nums = new int[]{1,2,0,0,2,1,0};
        threeWayPartition(nums, 0);

        for(int num : nums){
            System.out.print(num);
        }
    }
}
