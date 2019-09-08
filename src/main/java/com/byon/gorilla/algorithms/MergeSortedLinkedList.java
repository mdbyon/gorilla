//package com.byon.gorilla.algorithms;
//
//public class MergeSortedLinkedList {
//
//public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    ListNode head = new ListNode(-1);
//    ListNode res = head;
//    ListNode rem = null;
//    while(l1 != null && l2 != null){
//        if(l1.val <= l2.val){
//            head.next = l1;
//            l1 = l1.next;
//        } else{
//            head.next = l2;
//            l2 = l2.next;
//        }
//        head = head.next;
//    }
//
//    if(l1 == null){
//        rem = l2;
//    } else{
//        rem = l1;
//    }
//    while(rem != null){
//        head.next = rem;
//        rem = rem.next;
//        head = head.next;
//    }
//
//    return res.next;
//
//  }
//
//}
