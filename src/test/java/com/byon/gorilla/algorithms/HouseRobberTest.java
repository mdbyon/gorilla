package com.byon.gorilla.algorithms;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseRobberTest {

    @Test
    public void happy_path(){
        int [] input = new int[]{2,1,1,2};

        assertEquals(HouseRobber.rob(input), 4);
    }

}