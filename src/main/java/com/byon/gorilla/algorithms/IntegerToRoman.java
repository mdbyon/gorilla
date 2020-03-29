package com.byon.gorilla.algorithms;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {


    Map<Integer, ForDigit> map = new HashMap();

    class ForDigit {
        String floor;
        String mid;

        public ForDigit(String floor, String mid) {
            this.floor = floor;
            this.mid = mid;
        }
    }

    //4 and 9 takes the next base and prepends a 10 * curr digit place

//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000


    public String intToRoman(int num) {

        buildMap();

        char[] digits = Integer.toString(num).toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {

            if(digits[i] == '0') continue;

            if (digits[i] == '4') {
                result.append(map.get(digits.length - 1 - i).floor);
                result.append(map.get(digits.length - 1 - i).mid);

            } else if (digits[i] == '9') {
                result.append(map.get(digits.length - 1 - i).floor);
                result.append(map.get(digits.length - i).floor);
            } else {
                int currDigit = Integer.parseInt(String.valueOf(digits[i]));
                String floor = map.get(digits.length - 1 - i).floor;

                if (currDigit >= 5) {
                    floor = map.get(digits.length - 1 - i).mid;
                }

                result.append(floor);

                if (currDigit < 5) {
                    for (int j = 1; j < currDigit; j++) {
                        result.append(map.get(digits.length - 1 - i).floor);
                    }
                } else {
                    for (int j = 5; j < currDigit; j++) {
                        result.append(map.get(digits.length - 1 - i).floor);
                    }
                }
            }
        }

        return result.toString();
    }

    public void buildMap() {
        map.put(0, new ForDigit("I", "V"));
        map.put(1, new ForDigit("X", "L"));
        map.put(2, new ForDigit("C", "D"));
        map.put(3, new ForDigit("M", "M"));
    }

    public static void main(String[] args) {

        IntegerToRoman runner = new IntegerToRoman();

        System.out.println(runner.intToRoman(58));
    }
}
