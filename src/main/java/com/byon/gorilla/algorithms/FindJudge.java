package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindJudge {

    public int findJudge(int N, int[][] trust) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> trustMap = new HashMap<>();

        for(int i = 0; i<trust.length; i++){

            map.put(trust[i][0], map.getOrDefault(trust[i][0], 0));
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);

            List<Integer> trustees = new ArrayList<>();
            if(trustMap.containsKey(trust[i][0])){
                trustees = trustMap.get(trust[i][0]);
            }
            trustees.add(trust[i][1]);
            trustMap.put(trust[i][0], trustees);

        }

        int judges = 0;
        int judge = 0;
        for(int key : map.keySet()){
            if(map.get(key) == N - 1  && !trustMap.containsKey(key)) {
                judges++;
                judge = key;
            }
        }

        return judges == 1 ? judge : -1;
    }
}
