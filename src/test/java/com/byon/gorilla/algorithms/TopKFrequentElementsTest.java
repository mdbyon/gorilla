package com.byon.gorilla.algorithms;

import org.junit.Test;

import java.util.List;

import static com.byon.gorilla.algorithms.TopKFrequentElements.topKFrequent;
import static org.junit.jupiter.api.Assertions.*;

public class TopKFrequentElementsTest {

    @Test
    public void smoke_test(){
        int [] input = new int[]{5,2,5,3,5,3,1,1,3};

        List<Integer> result = topKFrequent(input, 2);

        assertEquals((int) result.get(0), 3);
        assertEquals((int) result.get(1), 5);

    }

}