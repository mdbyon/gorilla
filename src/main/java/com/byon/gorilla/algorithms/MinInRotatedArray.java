package com.byon.gorilla.algorithms;

public class MinInRotatedArray {

    int min = 0;

    public int findMin(int[] nums) {

        if (nums.length == 1) return nums[0];
        int low = 0;
        min = nums[0];
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if (nums[low] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return min;
    }
}
