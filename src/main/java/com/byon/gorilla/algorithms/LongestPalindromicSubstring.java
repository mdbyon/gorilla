package com.byon.gorilla.algorithms;

public class LongestPalindromicSubstring {

    // "babad" -> "bab"
    // "cbbd" -> "bb"

    // choice 1) recurse with left pointer + 1, right pointer;
    // choice 2) recurse with left pointer, right pointer - 1;

                                        //      palindrome(0, 4)
                                        //    /              \
                            // palindrome(1,4)               palindrome(0 , 3)
                //           /        \                          /           \
               // palindrome(2,4)     palindrome(1, 3)      palindrome(1,3)   palindrome(0 , 2)

    // " " -> 0
    // " any char " -> 1
    //if start char == end char -> return prev + 2

    int[][] maxLength = null;

    public String longestPalindromeDP(String s){

        boolean [][] dp = new boolean[s.length()][s.length()];
        maxLength = new int[s.length()][s.length()];

        int result = 1;
        String currResult = "";

        for(int i = 0; i<dp.length; i++){
            dp[i][i] = true;
            maxLength[i][i] = 1;
        }

        for(int i = 0; i<dp.length - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                maxLength[i][i + 1] = 2;
                currResult = s.substring(i, i + 2);
            }
        }


        for(int i = 2; i<s.length(); i++){
            for(int j = 0; j < s.length() - i; j++){
                if(s.charAt(j) == s.charAt(j + i)) {
                    if (dp[j + 1][j + i - 1]) {
                        dp[j][j + i] = true;
                        maxLength[j][j + i] = 2 + maxLength[j + 1][j + i - 1];

                        if (i + 1 > result) {
                            currResult = s.substring(j, j + i + 1);
                        }
                    }else{
                        maxLength[j][j + i] = Math.max(maxLength[j + 1][j + i], maxLength[j][j + i - 1]);
                    }
                }else{
                     maxLength[j][j + i] = Math.max(maxLength[j + 1][j + i], maxLength[j][j + i - 1]);
                }
            }
        }
        return currResult;
    }



    public static void main(String [] args){
        LongestPalindromicSubstring runner = new LongestPalindromicSubstring();

        System.out.println("==========> answer: " + runner.longestPalindromeDP("abacaca"));
        System.out.println("==========> cache: " + runner.maxLength[0][6]);
    }
}
