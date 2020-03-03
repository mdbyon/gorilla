package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.TreeNode;

import java.util.*;

public class VerticalTraversal {

    class NodeWithLevel{
        TreeNode node;
        int level;

        public NodeWithLevel(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    List<List<Integer>> result = new ArrayList();
    TreeMap<Integer, List<Integer>> map = new TreeMap();

    Queue<NodeWithLevel> queue = new LinkedList();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalTraversal(root, 0);

        for(int key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

    public void verticalTraversal(TreeNode root, int index) {

        if(root == null) return;

        queue.offer(new NodeWithLevel(root, index));

        while(!queue.isEmpty()){
            NodeWithLevel curr = queue.poll();

            List<Integer> currList = map.getOrDefault(curr.level, new ArrayList());
            currList.add(curr.node.val);
            map.put(curr.level, currList);

            if(curr.node.left != null) queue.offer(new NodeWithLevel(curr.node.left, curr.level - 1));
            if(curr.node.right != null) queue.offer(new NodeWithLevel(curr.node.right, curr.level + 1));

        }

    }

}
