package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LetterCombinations {

    List<String> result = new ArrayList<>();
    HashMap<Integer, String> phoneNumbers = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new ArrayList<>();
        phoneNumbers.put(2, "abc");
        phoneNumbers.put(3, "def");
        phoneNumbers.put(4, "ghi");
        phoneNumbers.put(5, "jkl");
        phoneNumbers.put(6, "mno");
        phoneNumbers.put(7, "pqrs");
        phoneNumbers.put(8, "tuv");
        phoneNumbers.put(9, "wxyz");

        permuteCombos(digits, 0, new StringBuilder());
        return result;
    }

    public void permuteCombos(String digits, int numberIndex, StringBuilder curr) {

        char[] phoneNumber = digits.toCharArray();

        if (numberIndex == phoneNumber.length) {
            result.add(curr.toString());
            return;
        }

        String digitMap = phoneNumbers.get(Character.getNumericValue(phoneNumber[numberIndex]));

        char[] lettersFromDigit = digitMap.toCharArray();

        for (int i = 0; i < lettersFromDigit.length; i++) {
            curr.append(lettersFromDigit[i]);
            permuteCombos(digits, numberIndex + 1, curr);
            curr.deleteCharAt(numberIndex);
        }
    }
}