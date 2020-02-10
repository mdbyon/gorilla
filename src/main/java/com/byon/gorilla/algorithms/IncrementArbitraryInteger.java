package com.byon.gorilla.algorithms;

public class IncrementArbitraryInteger {

    public static void increment(int [] nums){

        int carry = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] + carry  >= 10){
                if(i == 0) {
                    nums[i] = (nums[i] + carry) % 10;
                    int [] temp = nums;

                    nums = new int[temp.length + 1];
                    nums[0] = 1;

                    for(int j = 0; j < temp.length; j++){
                        nums[j + 1] = temp[j];
                    }

                }else {
                    nums[i] = (nums[i] + carry) % 10;
                    carry = 1;
                }
            } else{
                nums[i] = nums[i] + carry;
                break;
            }
        }
    }

    public static void main(String [] args){
        int [] nums = new int[]{9,9,9};
        increment(nums);

        for(int num : nums){
            System.out.print(num);
        }
    }
}
