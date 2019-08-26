package com.byon.gorilla.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeatedStringMatchTest {

    @Test
    public void repeatedStringMatch(){
        String A = "aaac";
        String B = "aac";
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        int result = repeatedStringMatch.repeatedStringMatch(A,B);
        assertEquals(result, 1);
    }
}
