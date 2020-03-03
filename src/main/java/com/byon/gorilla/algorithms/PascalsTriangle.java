package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();

        if (numRows == 0) return result;

        List<Integer> head = new ArrayList();
        head.add(1);
        result.add(head);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currList = new ArrayList();

            currList.add(1);

            List<Integer> prevList = result.get(result.size() - 1);

            for (int j = 1; j < prevList.size(); j++) {
                currList.add(prevList.get(j - 1) + prevList.get(j));
            }

            currList.add(1);
            result.add(currList);
        }

        return result;
    }
}
