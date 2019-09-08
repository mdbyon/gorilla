package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {

    public static  class Temperature {
        int index;
        int val;

        public Temperature(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }


    //Key insight was the fact that we only push in the stack when items are decreasing
    //and we continue to remove from the stack while the top item is less than the current item in list
    // if a > b > c then a > c

    //if a < b > c then we check to see if a < c as well as any remaining items in stack

    public static int[] dailyTemperatures(int[] T) {

        List<Temperature> temperatures = new ArrayList<>();
        for (int i = 0; i < T.length; i++) {
            temperatures.add(new Temperature(i, T[i]));
        }

        int[] result = new int[T.length];
        Stack<Temperature> stack = new Stack<>();

        if (T == null || T.length == 0) {
            return result;
        }

        stack.push(temperatures.get(0));
        int resultIndex = 0;
        for (int i = 1; i < temperatures.size(); i++) {

            Temperature curr = stack.peek();
            if(curr.val > temperatures.get(i).val) {
                stack.push(temperatures.get(i));
            } else {
                while(!stack.empty() && stack.peek().val < temperatures.get(i).val) {
                    result[stack.peek().index] = i - stack.peek().index;
                    stack.pop();
                }
                stack.push(temperatures.get(i));
            }

        }

        while (!stack.empty()) {
            result[stack.peek().index] = 0;
            stack.pop();
        }

        return result;
    }

}
