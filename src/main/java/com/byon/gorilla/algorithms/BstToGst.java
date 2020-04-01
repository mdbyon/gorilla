package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

public class BstToGst {


    public TreeNode bstToGst(TreeNode root) {
        walk(root);

        return root;
    }

    int currSum = 0;


    public void walk(TreeNode root){
        if(root == null) return;

        walk(root.right);
        currSum+= root.val;
        root.val = currSum;
        walk(root.left);

    }
}
