package com.byon.gorilla.algorithms;

import com.byon.gorilla.models.ListNode;

public class GasupProblem {

    class ListNode {
        int val;
        int idx;
        ListNode next;

        public ListNode(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    ListNode head;
    ListNode curr = new ListNode(0, 0);
    int lastFail = 0;

    public int findAmpleStart(int[] gasAtStation, int[] distanceToNextStation) {
        for (int i = 0; i < gasAtStation.length - 1; i++) {
            if (i == 0) {
                head = new ListNode(gasAtStation[i], i);
                curr.next = head;
                curr = curr.next;
            } else {
                curr.next = new ListNode(gasAtStation[i], i);
                curr = curr.next;
            }
            curr = new ListNode(gasAtStation[i], i);
            curr.next = head;
        }


        int sum = 0;
        int miles = 3000;
        int idx = 0;
        ListNode last = head;

        while (true) {
            sum += head.val * 20;

            if (sum >= 3000) return last.next.idx;

            if (sum < distanceToNextStation[idx]) {
                last = head;
                sum = 0;
            } else {
                sum -= distanceToNextStation[idx];
            }

            idx = (idx + 1) % distanceToNextStation.length;
            head = head.next;
        }
    }
}
