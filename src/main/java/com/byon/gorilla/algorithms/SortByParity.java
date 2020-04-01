package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SortByParity {

    public static int [] sortArrayByParity(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    public static void sortArrayByParity(int[] A, int start, int end) {

        if(start == end) return;

        int mid = start + (end - start)/2;
        sortArrayByParity(A, start, mid);
        sortArrayByParity(A, mid + 1, end);

        mergeSort(A, start, end);

    }

    public static void mergeSort(int [] A, int start, int end){
        List<Integer> even = new ArrayList();
        List<Integer>odd = new ArrayList();

        for(int i = start; i<= end; i++){
            if(A[i] %2 == 0) {
                even.add(A[i]);
            }else{
                odd.add(A[i]);
            }
        }

        int idx = start;

        for(int i = 0; i< even.size(); i++){
            A[idx++] = even.get(i);
        }

        for(int i = 0; i< odd.size(); i++){
            A[idx++] = odd.get(i);
        }
    }

    public static void main(String [] args){
        int [] result = sortArrayByParity(new int [] {3,1,2,4});
        System.out.println(result);

    }
}
