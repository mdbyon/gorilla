package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

public class LevelNext {

    public void performLevelNext(TreeNode root){
        levelNext(root, null);
    }


    public void levelNext(TreeNode curr, TreeNode right){
        if(curr == null) return;

        curr.left.rightSibling = curr.right;
        curr.right.rightSibling = right;

        levelNext(curr.left, curr.right);
        levelNext(curr.right, right.left);

    }
}
