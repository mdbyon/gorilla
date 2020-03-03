package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> currResult = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList();

            while (!queue.isEmpty()) {

                TreeNode curr = queue.poll();
                currResult.add(curr.val);

                if (curr.left != null) {
                    temp.offer(curr.left);

                }
                if (curr.left != null) {
                    temp.offer(curr.right);
                }
            }

            result.add(0, currResult);
            queue = temp;

        }
        return result;
    }
}
