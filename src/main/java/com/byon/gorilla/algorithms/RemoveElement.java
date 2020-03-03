package com.byon.gorilla.algorithms;

import java.util.Arrays;

public class RemoveElement{

    //element left of p1 will always be less than p1
    //if p1 is at head then all elements are greater
    // advance p1 while less than target
    // at end of loop if p1 is equal to target move p2 out until it is out of range
    //


  public static int removeElement(int [] nums, int target){
      Arrays.sort(nums);

      int p1 = 0;

      while(p1 < nums.length && nums[p1] != target) p1++;

      int p2 = p1;
      while(p2 < nums.length && nums[p2] == nums[p1]) p2++;

      while(p2 < nums.length){
          nums[p1] = nums[p2];
          p1++;
          p2++;
      }

      return p1;
  }

  public static void main(String [] args){
      System.out.println(removeElement(new int[]{4,5,5}, 4));
  }

}
