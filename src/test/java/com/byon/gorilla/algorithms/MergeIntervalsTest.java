package com.byon.gorilla.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static com.byon.gorilla.algorithms.MergeIntervals.merge;
import static org.junit.jupiter.api.Assertions.*;

public class MergeIntervalsTest {

    @Test
    public void happy_path() {
        int[][] input = new int[][]{{1, 4}, {0, 2}, {3, 5}};

        int[][] result = merge(input);


        assertEquals(result[0][0], 0);
        assertEquals(result[0][1], 5);
    }
}