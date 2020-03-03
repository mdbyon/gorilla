package com.byon.gorilla.algorithms;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {

        int max = Integer.MIN_VALUE;
        int actualSum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            actualSum += num;
        }


        int sumWithNoDups = 0;
        for (int i = 1; i <= max; i++) {
            sumWithNoDups += i;
        }

        int index = 1;

        while ((index * (nums.length - 1)) + max < actualSum) {
            index++;
        }

        if (index == max) return max;

        int j = nums.length - 1;

        int curr = index * j + max;

        int prev = max;
        int tail = max;
        while (curr > actualSum) {
            tail--;
            prev = prev + tail;
            curr = curr - index + prev;
        }

        if (curr == actualSum) {
            return index;
        }
        return index + 1;

    }

    public static void main(String[] args) {
        System.out.println("==============> " + findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
