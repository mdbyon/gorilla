package com.byon.gorilla.algorithms;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

        dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;

        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            for (int j = obstacleGrid[0].length - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
        if (row >= obstacleGrid.length
                || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1) return 0;

        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) return 1;

        return uniquePathsWithObstacles(obstacleGrid, row + 1, col)
                + uniquePathsWithObstacles(obstacleGrid, row, col + 1);


    }
}
