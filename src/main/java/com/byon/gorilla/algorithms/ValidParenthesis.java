package com.byon.gorilla.algorithms;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        char [] letters = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(Character letter : letters){
            if(!stack.empty() && stack.peek().equals(letter)){
                stack.pop();
            } else{
                stack.push(letter);
            }
        }

        return stack.empty();
    }
}
