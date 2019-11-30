package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

import java.util.HashMap;

public class LowestCommonAncestor {

    HashMap<TreeNode, Source> getSource = new HashMap();

    class Source{
        int left;
        int right;
        int self;

        Source(int left, int right, int self){
            this.left = left;
            this.right = right;
            this.self = self;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        populateSourceForNode(root, p.val);
        populateSourceForNode(root, q.val);

        while(root != null){

            if(getSource.get(root).left == getSource.get(root.right).right) return root;

            if(getSource.get(root).left > getSource.get(root.right).right) {
                root = root.left;
            } else{
                root = root.right;
            }
        }
        return null;
    }

    public boolean populateSourceForNode(TreeNode root, int target){
        if(root == null) return false;

        if(root.val == target) {
            getSource.put(root, new Source(0, 0, target));
            return true;
        }

        boolean found = false;

        if(populateSourceForNode(root.left, target)){
            if(getSource.containsKey(root)){
                Source curr = getSource.get(root);
                curr.left++;
                getSource.put(root, curr);
            } else{
                getSource.put(root, new Source(1, 0, 0));
            }
            found = true;
        }


        if(populateSourceForNode(root.right, target)){
            if(getSource.containsKey(root)){
                Source curr = getSource.get(root);
                curr.right++;
                getSource.put(root, curr);
            } else{
                getSource.put(root, new Source(0, 1, 0));
            }
            found = true;
        }
        return found;
    }
}
