package com.byon.gorilla.algorithms;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseBitsTest {

    @Test
    public void happy_path(){
        int result = ReverseBits.reverseBits(43261596);

        assertEquals(result,    964176192);

    }

}