package com.byon.gorilla.algorithms;

public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        int mask = 1;

        for(int i = 0; i<32; i++){
            int lastVal = n & mask;
            result |= lastVal;
            result = result << 1;
            n = n >> 1;
        }
        return result;
    }
}
