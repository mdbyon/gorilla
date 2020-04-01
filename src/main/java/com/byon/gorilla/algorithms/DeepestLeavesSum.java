package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DeepestLeavesSum {

    int deepestLevel = 0;
    Map<Integer, Integer> getSum = new HashMap();

    public int deepestLeavesSum(TreeNode root) {
        deepestLevelSum(root, 0);
        return getSum.get(deepestLevel);
    }

    public void deepestLevelSum(TreeNode root, int level){
        if(root == null){
            deepestLevel = Math.max(deepestLevel, level);
            getSum.put(level, getSum.getOrDefault(level, 0) + root.val);
            return;
        }

        if(root.left != null) deepestLevelSum(root.left, level + 1);
        if(root.right != null) deepestLevelSum(root.right, level + 1);

    }
}
