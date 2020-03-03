package com.byon.gorilla.algorithms;

import java.util.Stack;

public class ValidParenthesisWithWildCard {

    Stack<Character> defaultStack = new Stack();
    Stack<Character> wildCard = new Stack();

    public boolean checkValidString(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                if (!defaultStack.isEmpty()) {
                    defaultStack.pop();
                } else if (!wildCard.isEmpty()) {
                    wildCard.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '(') {
                defaultStack.push(s.charAt(i));
            } else {
                wildCard.push('*');
            }
        }
        return defaultStack.isEmpty();
    }


}
