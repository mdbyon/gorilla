package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

public class MaximumBinaryTree {

    /*
    Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
     */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        //max num is root -> root.right is rec(rootIndex + 1, end)
        // root.left(start, rootIndex - 1)
        // iterate from start to end to figure out max

        if(start > end || end < start) return null;

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for(int i = start; i<=end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);

        return root;


    }

    public static void main(String [] args){

    }
}
