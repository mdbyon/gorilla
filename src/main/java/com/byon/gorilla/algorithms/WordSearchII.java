package com.byon.gorilla.algorithms;


import java.util.*;

public class WordSearchII {

    Set<String> result = new HashSet();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    StringBuilder curr = new StringBuilder();
                    findWord(board, i, j, word, curr, new boolean[board.length][board[0].length]);
                }
            }
        }

        List<String> asList = new ArrayList<>();
        for (String word : result) {
            asList.add(word);
        }

        return asList;
    }

    public void findWord(char[][] board, int row, int col, String target, StringBuilder curr, boolean[][] visited) {

        if (target.equals(curr.toString())) {
            result.add(curr.toString());
            return;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return;


        if (board[row][col] == target.charAt(curr.length())) {

            visited[row][col] = true;
            curr.append(board[row][col]);

            findWord(board, row - 1, col, target, curr, visited);
            findWord(board, row + 1, col, target, curr, visited);
            findWord(board, row, col + 1, target, curr, visited);
            findWord(board, row, col - 1, target, curr, visited);

            visited[row][col] = false;

            curr.deleteCharAt(curr.length() - 1);
        }
    }


    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'b', 'a', 'a', 'b', 'a', 'b'},
                {'a', 'b', 'a', 'a', 'a', 'a'},
                {'a', 'b', 'a', 'a', 'a', 'b'},
                {'a', 'b', 'a', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'a', 'a', 'b'}
        };

        WordSearchII runner = new WordSearchII();
        List<String> result = runner.findWords(arr,
                new String [] {"aabbbbabbaababaaaabababbaaba","abaabbbaaaaababbbaaaaabbbaab","ababaababaaabbabbaabbaabbaba"});
        System.out.println(result.get(0));
    }
}
