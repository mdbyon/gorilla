package com.byon.gorilla.algorithms;

public class SortColors {

    public static void sortColors(int[] nums) {

        int oneIndex = 0;
        int twoIndex = nums.length - 1;
        int index = 0;

        while(index < nums.length){
            if(index >= twoIndex){
                break;
            }
            while(nums[index] == 0 || nums[index] == 2){

                if(nums[index] == 0){
                    swap(oneIndex, index, nums);
                    if(index == oneIndex){
                        oneIndex++;
                        break;
                    }
                    oneIndex++;
                }

                if(nums[index] == 2){
                    swap(twoIndex, index, nums);
                    twoIndex--;
                }
            }
            index++;
        }
    }


    private static void swap(int firstIndex, int secondIndex, int [] nums){
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
