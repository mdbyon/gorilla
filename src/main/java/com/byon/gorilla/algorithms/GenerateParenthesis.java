package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, n, new StringBuilder());
        return result;
    }

    public void generateParenthesis(int n, int leftRem, int rightRem, StringBuilder currString) {
        if (currString.length() == 2 * n) {
            result.add(currString.toString());
            return;
        }

        if (leftRem > 0) {
            currString.append("(");
            generateParenthesis(n, leftRem - 1, rightRem, currString);
            currString.deleteCharAt(currString.length() - 1);
        }

        if (rightRem > leftRem) {
            currString.append(")");
            generateParenthesis(n, leftRem, rightRem - 1, currString);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}
