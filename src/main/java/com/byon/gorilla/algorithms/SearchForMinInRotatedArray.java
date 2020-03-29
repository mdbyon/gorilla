package com.byon.gorilla.algorithms;

public class SearchForMinInRotatedArray {

    public static int findMin(int [] arr){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            if(arr[high] > arr[low]) return arr[low];

            int mid = low + (high - low)/2;

            if(arr[mid] > arr[high]){
                low = mid + 1;
            }else{
                if(arr[mid] < arr[mid - 1]) return arr[mid];
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        System.out.println(findMin(new int[]{378,478,550,631,103,203,220}));
    }
}
