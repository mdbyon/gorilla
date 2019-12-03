package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

public class MergeBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return null;

        if(t2 == null) return t1;

        if(t1 == null) return t2;

        t1.val += t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
