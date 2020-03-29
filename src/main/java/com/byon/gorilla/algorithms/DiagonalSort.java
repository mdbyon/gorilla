package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {
        // row + 1, col + 1
        // from row.length to 0 -> sort
            // dump to array -> arrays.sort
        // from col 0 to row[0].length -> sort
            // dump to array -> arrays.sort

        for(int row = mat.length - 1; row >= 0; row--){

            List<Integer> curr = new ArrayList<>();
            int col = 0;
            int origRow = row;

            while(row < mat.length && col < mat[0].length){
                curr.add(mat[row][col]);
                row++;
                col++;
            }
            int [] diag = new int[curr.size()];
            for(int i = 0; i<curr.size(); i++){
                diag[i] = curr.get(i);
            }

            Arrays.sort(diag);

            col = 0;
            row = origRow;

            while(row < mat.length && col < mat[0].length){
                mat[row][col] = diag[col];
                row++;
                col++;
            }

        }

        for(int col = 1; col < mat[0].length; col++){

            List<Integer> curr = new ArrayList<>();
            int row = 0;
            int origCol = col;

            while(row < mat.length && col < mat[0].length){
                curr.add(mat[row][col]);
                row++;
                col++;
            }

            int [] diag = new int[curr.size()];

            for(int i = 0; i<curr.size(); i++){
                diag[i] = curr.get(i);
            }

            Arrays.sort(diag);

            row = 0;
            col = origCol;

            while(row < mat.length && col < mat[0].length){
                mat[row][col] = diag[row];
                row++;
                col++;
            }

        }

        return mat;

    }
}
