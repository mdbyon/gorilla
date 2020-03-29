package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MatrixReshape {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        List<Integer> flat = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                flat.add(nums[i][j]);
            }
        }

        if (r * c < flat.size()) return nums;

        int idx = 0;

        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = flat.get(idx);
                idx++;
            }
        }
        return result;
    }
}
