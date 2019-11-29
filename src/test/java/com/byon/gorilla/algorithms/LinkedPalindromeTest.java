package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.ListNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedPalindromeTest {

    @Test
    public void smoke_test(){
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(2);
        p1.next.next.next = new ListNode(1);

        assertTrue(LinkedPalindrome.isPalindrome(p1));
    }

}