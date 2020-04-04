package com.byon.gorilla.algorithms;

import java.util.*;

public class QueueReconstruction {


    public class Pair {
        int height;
        int pos;

        public Pair(int height, int pos) {
            this.height = height;
            this.pos = pos;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair o1, Pair o2) {

            if (o1.height == o2.height) {
                if (o1.pos < o2.pos) {
                    return -1;
                } else if (o1.pos > o2.pos) {
                    return 1;
                }
                return 0;
            }

            if (o1.height < o2.height) {
                return -1;
            }
            return 1;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator());
        List<Pair> reordered = new ArrayList<>();

        for (int[] pair : people) {
            queue.offer(new Pair(pair[0], pair[1]));
        }

        while(queue.isEmpty()){
            reordered.add(queue.peek().pos, queue.poll());
        }

        int [][] result = new int[people.length][people[0].length];

        for(int i = 0; i<reordered.size(); i++){
            result[i] = new int[]{reordered.get(i).height, reordered.get(i).pos};
        }

        return result;

    }

}
