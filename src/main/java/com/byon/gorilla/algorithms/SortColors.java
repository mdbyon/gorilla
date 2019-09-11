package com.byon.gorilla.algorithms;

public class SortColors {

    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int pivotIndex = 0;

        while(nums[p1] != 0 && nums[p2] != 0){
            p1++;
            p2--;
        }
        if(nums[p1] == 0){
            pivotIndex = p1;
        } else{
            pivotIndex = p2;
        }

        partition(nums, pivotIndex, 0, nums.length - 1);
    }

    public void partition (int [] nums, int pivot, int start, int end){

        int pivotIndex = start;

        while(pivotIndex <= end){
            if(nums[pivotIndex] <= nums[pivot]){
                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[start];
                nums[start] = temp;
                start++;
            }
            pivotIndex++;
        }

        int temp = nums[start - 1];
        nums[start - 1] = nums[pivot];
        nums[pivot] = temp;

    }
}
