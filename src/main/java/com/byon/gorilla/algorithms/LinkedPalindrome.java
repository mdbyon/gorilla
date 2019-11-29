package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.ListNode;

public class LinkedPalindrome {


    public static boolean isPalindrome(ListNode head) {
        ListNode front = head;
        if (head == null || head.next == null) return true;

        ListNode p2 = head;
        int size = getSize(head);
        int advanceTo = ((size - 1) / 2) + 1;

        while (advanceTo > 0 && p2 != null) {
            p2 = p2.next;
            advanceTo--;
        }

        int reverseTo = 0;
        if (size % 2 == 0) {
            reverseTo = (size - 1) / 2;
        } else {
            reverseTo = (size - 1) / 2 - 1;
        }
        ListNode p1 = reverseTo(front, reverseTo);

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 == null && p1 != null) return false;

        return true;


    }

    public static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static ListNode reverseTo(ListNode head, int index) {

        ListNode prev = null;
        ListNode next = null;
        int curr = 0;

        if (index == 0) {
            head.next = null;
            return head;
        }

        while (curr < index) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            curr++;
        }
        head.next = prev;
        return head;
    }
}
