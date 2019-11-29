package com.byon.gorilla.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return intervals;

        Arrays.sort(intervals, new Comparator<int []>() {
            public int compare(int [] first, int [] second) {
                return Integer.compare(first[0], second[0]);
            }});

        int [][] result = new int[intervals.length][intervals[0].length];
        int resultIndex = 0;

        result[resultIndex][0] = intervals[0][0];
        result[resultIndex][1] = intervals[0][1];

        for(int i = 1; i< intervals.length; i++){

            if(result[resultIndex][1] < intervals[i][0]){
                resultIndex++;
                result[resultIndex][0] = intervals[i][0];
                result[resultIndex][1] = intervals[i][1];
            }
            else{
                result[resultIndex][1] = Math.max(result[resultIndex][1], intervals[i][1]);
            }
        }

        int [][] trimmedResult = new int[resultIndex + 1][result[0].length];

        for(int i = 0; i<resultIndex + 1; i++){
            trimmedResult[i] = result[i];
        }

        return trimmedResult;
    }
}
