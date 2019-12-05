package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        //push all k items in heap;
        //pop top off and add to result
        //if top.next != null add to heap
        //continue until heap is empty
        ListNode head = new ListNode(0);
        ListNode curr = head;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                if(n1.val > n2.val) return -1;
                if(n1.val < n1.val) return 1;
                return 0;
            }
        });

        for(ListNode list : lists){
            minHeap.add(list);
        }

        while(minHeap.size() > 0){
            ListNode top = minHeap.poll();
            curr.next = new ListNode(top.val);
            curr = curr.next;

            if(top.next != null) minHeap.add(top.next);

        }

        return head.next;
    }
}
