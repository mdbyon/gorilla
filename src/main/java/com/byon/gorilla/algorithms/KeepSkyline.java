package com.byon.gorilla.algorithms;

public class KeepSkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [] rows = new int[grid.length];
        int [] cols = new int[grid[0].length];

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }

        int sum = 0;

        int [][] altered = new int[grid.length][grid[0].length];

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] != Math.max(rows[i], cols[j])){
                    altered[i][j] = Math.min(rows[i], cols[j]);
                }else{
                    altered[i][j] = grid[i][j];
                }
            }
        }

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                sum+= altered[i][j] - grid[i][j];
            }
        }

        return sum;
    }

}
