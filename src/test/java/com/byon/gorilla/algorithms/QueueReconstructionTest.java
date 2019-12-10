package com.byon.gorilla.algorithms;

import org.junit.Test;

import static com.byon.gorilla.algorithms.QueueReconstruction.reconstructQueue;
import static org.junit.jupiter.api.Assertions.*;

public class QueueReconstructionTest {

    @Test
    public void happy_path(){
        int [][]input = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(input);
    }

}