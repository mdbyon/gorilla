package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

    public static class Pair{
        int height;
        int pos;

        public Pair(int height, int pos){
            this.height = height;
            this.pos = pos;
        }
    }

    public static int[][] reconstructQueue(int[][] people) {

        List<Pair> peopleObjects = new ArrayList();

        for(int [] person : people){
            peopleObjects.add(new Pair(person[0], person[1]));
        }

        int[][] result = new int[peopleObjects.size()][2];

        Comparator<Pair> cmp = new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                if(o1.height < o2.height) return -1;
                if(o1.height > o2.height) return 1;

                if(o1.pos < o2.pos) return - 1;

                return 0;
            }
        };

        Collections.sort(peopleObjects, cmp);

        for(int i = 0; i<peopleObjects.size(); i++){
            if(peopleObjects.get(i).pos > i){
                Collections.swap(peopleObjects, peopleObjects.get(i).pos, i);
            } else{
                if(peopleObjects.get(peopleObjects.get(i).pos).height > peopleObjects.get(i).height){
                    Collections.swap(peopleObjects, peopleObjects.get(i).pos, i);
                }
            }
        }

        for(int i = 0; i<peopleObjects.size();i++){
            result[i][0] =peopleObjects.get(i).height;
            result[i][1] = peopleObjects.get(i).pos;
        }

        return result;


    }

}
