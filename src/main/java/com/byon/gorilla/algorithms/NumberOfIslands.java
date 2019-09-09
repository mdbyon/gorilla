package com.byon.gorilla.algorithms;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {

    public class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {

        int result = 0;

        if (grid.length > 0) {
            Queue<Cell> queue = new LinkedList<>();
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        result++;
                        queue.add(new Cell(i, j));
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            Cell curr = queue.remove();

                            if (curr.row < grid.length - 1 && grid[curr.row + 1][curr.col] == '1' && !visited[curr.row + 1][curr.col]) {
                                queue.add(new Cell(curr.row + 1, curr.col));
                                visited[curr.row + 1][curr.col] = true;
                            }
                            if (curr.col < grid[0].length - 1 && grid[curr.row][curr.col + 1] == '1' && !visited[curr.row][curr.col + 1]) {
                                queue.add(new Cell(curr.row, curr.col + 1));
                                visited[curr.row][curr.col + 1] = true;
                            }

                            if (curr.row > 0 && grid[curr.row - 1][curr.col] == '1' && !visited[curr.row - 1][curr.col]) {
                                queue.add(new Cell(curr.row - 1, curr.col));
                                visited[curr.row - 1][curr.col] = true;
                            }

                            if (curr.col > 0 && grid[curr.row][curr.col - 1] == '1' && !visited[curr.row][curr.col - 1]) {
                                queue.add(new Cell(curr.row, curr.col - 1));
                                visited[curr.row][curr.col - 1] = true;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

}
