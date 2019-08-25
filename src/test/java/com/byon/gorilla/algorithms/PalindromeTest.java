package com.byon.gorilla.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void palindrome_test() {
        boolean result = Palindrome.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        assertEquals(true, result);

    }
}
