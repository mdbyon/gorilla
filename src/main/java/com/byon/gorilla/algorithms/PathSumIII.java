package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    int result = 0;

    public int pathSum(TreeNode root, int sum) {
        pathSumRec(root, sum);

        return result;
    }

    public List<Integer> pathSumRec(TreeNode root, int sum) {
        if (root == null) return new ArrayList<Integer>();

        if (root.left == null && root.right == null) {
            if (root.val == sum) result++;
            List<Integer> set = new ArrayList<Integer>();
            set.add(root.val);
            return set;
        }

        List<Integer> fromLeft = pathSumRec(root.left, sum);
        List<Integer> fromRight = pathSumRec(root.right, sum);

        List<Integer> combined = new ArrayList<Integer>();

        for (int key : fromLeft) {
            combined.add(key + root.val);
        }

        for (int key : fromRight) {
            combined.add(key + root.val);
        }

        combined.add(root.val);

        for (int key : combined) {
            if (key == sum) result++;
        }

        return combined;
    }
}
