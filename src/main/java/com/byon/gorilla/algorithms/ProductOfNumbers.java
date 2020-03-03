package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ProductOfNumbers {

    Stack<Integer> stack = new Stack();

    List<Integer> lastZero = new ArrayList();
    List<Integer> cumulativeProd = new ArrayList();
    int index = 0;


    public ProductOfNumbers() {
        cumulativeProd.add(1);
    }

    public void add(int num) {

        if(num == 0){
            lastZero.add(cumulativeProd.size() - 1);
        }

        else{
            cumulativeProd.add(num * cumulativeProd.get(cumulativeProd.size() - 1));
        }
        index++;
    }

    public int getProduct(int k) {
        if(lastZero.size() > 0 && index - k <= lastZero.get(lastZero.size() - 1)){
            return 0;
        }

        int sizeOfList = cumulativeProd.size();

        if(cumulativeProd.size() - 1 - k < 0) return cumulativeProd.get(cumulativeProd.size() - 1);

        int answer = cumulativeProd.get(cumulativeProd.size() - 1) / cumulativeProd.get(cumulativeProd.size() - 1 - k);
        return answer;
    }

    public static void main(String [] args){
        ProductOfNumbers test = new ProductOfNumbers();
        test.add(1);
        test.add(2);
        test.add(3);
        test.getProduct(3);
        test.add(4);
        test.add(5);

    }
}
