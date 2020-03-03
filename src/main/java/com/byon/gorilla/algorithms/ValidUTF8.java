package com.byon.gorilla.algorithms;

public class ValidUTF8 {

    public static boolean validUtf8(int[] data) {

        for(int i = 0; i<data.length; i++){
            int numOfContinuations = getNumOfContinuations(data[i]);

            if(numOfContinuations < 0) return false;

            while(numOfContinuations > 0){
                if(i + 1 == data.length || data[i + 1] >>> 6 != 2){
                    return false;
                }
                i++;
                numOfContinuations--;
            }

        }
        return true;
    }

    public static int getNumOfContinuations(int num){
        int curr = num >>> 3;
        System.out.println(curr);
        if((curr & 1) == 1) return -1;

        curr>>>= 1;

        if(curr == 15) return 3;

        if(curr == 14) return 2;

        if(curr == 12) return 1;

        if(curr == 0) return 0;

        return -1;
    }

    public static void main(String [] args){
        System.out.println(validUtf8(new int[]{248,130,130,130}));
    }
}
