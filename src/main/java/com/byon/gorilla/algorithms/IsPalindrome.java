package com.byon.gorilla.algorithms;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        char[] letters = s.toCharArray();

        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            if(!Character.isLetterOrDigit(letters[p1])) {
                p1++;
                continue;
            }
            if(!Character.isLetterOrDigit(letters[p2])) {
                p2--;
                continue;
            }

            if ((Character.isLetterOrDigit(letters[p1]) && Character.isLetterOrDigit(letters[p2]) &&
                    Character.toLowerCase(letters[p1]) == Character.toLowerCase(letters[p2]))) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }
}
