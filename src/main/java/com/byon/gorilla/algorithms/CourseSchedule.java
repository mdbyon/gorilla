package com.byon.gorilla.algorithms;

import java.util.*;

public class CourseSchedule {


    HashMap<Integer, Node> graph = new HashMap();
    int coursesFinished = 0;

    public class Node {
        int val;
        int indegree = 0;
        List<Node> children = new ArrayList();

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        buildGraph(prerequisites);
        Queue<Node> queue = new ArrayDeque<>();

        for(int course : graph.keySet()){
            if(graph.get(course).indegree == 0){
                queue.offer(graph.get(course));
                coursesFinished++;
            }
        }

        bfs(queue);

        return coursesFinished == graph.keySet().size();
    }

    public void bfs(Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node child : curr.children) {
                child.indegree--;

                if (child.indegree == 0) {
                    queue.offer(child);
                    coursesFinished++;
                }
            }
        }
    }

    public void buildGraph(int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            Node curr = null;
            if (graph.containsKey(prerequisites[i][1])) {
                curr = graph.get(prerequisites[i][1]);
            } else {
                curr = new Node(prerequisites[i][1]);
            }
            Node child = null;

            if (graph.containsKey(prerequisites[i][0])) {
                child = graph.get(prerequisites[i][0]);
            } else {
                child = new Node(prerequisites[i][0]);
                child.indegree++;
            }

            curr.children.add(child);
            graph.put(prerequisites[i][1], curr);

            if (!graph.containsKey(prerequisites[i][0])) {
                graph.put(prerequisites[i][0], child);
            }
        }
    }


}
