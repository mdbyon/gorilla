package com.byon.gorilla.algorithms;

public class Palindrome {

    public static boolean validPalindrome(String s) {

        char [] letters = s.toCharArray();
        int head = 0;
        int tail = letters.length - 1;
        boolean triedHead = false;
        int lastHeadIndex = 0;
        int lastTailIndex = 0;
        boolean triedTail = false;

        while(head < tail){

            if(letters[head] == letters[tail]){
                head++;
                tail--;
            } else{
                if(triedHead && triedTail){
                    return false;
                }
                if(triedHead){
                    triedTail = true;
                    head = lastHeadIndex;
                    tail = lastTailIndex;
                    tail--;
                } else{
                    triedHead = true;
                    lastHeadIndex = head;
                    lastTailIndex = tail;
                    head++;
                }
            }
        }
        return true;
    }
}
