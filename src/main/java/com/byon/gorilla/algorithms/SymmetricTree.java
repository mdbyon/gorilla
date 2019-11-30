package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root){
        return isSymmetricRec(root, root);
    }

    public boolean isSymmetricRec(TreeNode root, TreeNode sibling) {
        if(root == null && sibling == null) return true;

        if((root != null && sibling == null )|| (root == null && sibling != null)) {
            return false;
        }

        if(root.val == sibling.val){
            return isSymmetricRec(root.right, sibling.left) && isSymmetricRec(root.left, sibling.right);
        }
        return false;
    }

}
