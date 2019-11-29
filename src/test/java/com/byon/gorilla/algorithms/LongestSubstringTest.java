package com.byon.gorilla.algorithms;

import org.junit.Test;

import static com.byon.gorilla.algorithms.LongestSubstring.lengthOfLongestSubstring;
import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringTest {

    @Test
    public void happy_path(){
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);

        assertEquals(result, 3);
    }

}