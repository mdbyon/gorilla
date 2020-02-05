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


    public static int longestPalindrome(String s, int start, int end){
        if(end < start) return 0;

        if(end == start) return 1;

        if(s.charAt(start) == s.charAt(end)){
            return 2 + longestPalindrome(s, start + 1, end - 1);
        }
        return Math.max(longestPalindrome(s, start + 1, end), longestPalindrome(s, start, end - 1));

    }

    int [][] dp = null;

    public int [][] longestPalindromeDP(String s){

        dp = new int[s.length()][s.length()];

        int result = Integer.MIN_VALUE;

        for(int i = 0; i<dp.length; i++){
            dp[i][i] = 1;
        }

        for(int i = 0; i<dp.length - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = 2;
            }
            result = Math.max(result, dp[i][i + 1]);
        }


        for(int i = 3; i<s.length(); i++){
            for(int j = 0; j < s.length() - i; j++){
                if(s.charAt(j) == s.charAt(j + i)){
                    dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                } else{
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
                result = Math.max(result, dp[j][j + i]);
            }
        }
        System.out.println(result);
        return dp;
    }

    public String getLongestPalindrome(int [][] dp, String original){
        int longest = Integer.MIN_VALUE;

        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j<dp[0].length;j++){
                longest = Math.max(longest, dp[i][j]);
            }
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                if(dp[i][j] == longest){
                    return original.substring(i, j + 1);
                }
            }
        }
        return "";
    }


    public static void main(String [] args){
        LongestPalindromicSubstring runner = new LongestPalindromicSubstring();
        int [][] cache = runner.longestPalindromeDP("cbbd");

        System.out.println("==========> answer: " + runner.getLongestPalindrome(cache, "cbbd"));
    }
}
