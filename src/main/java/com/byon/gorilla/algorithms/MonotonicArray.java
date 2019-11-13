package com.byon.gorilla.algorithms;

class MonotonicArray {

    public boolean isMonotonic(int[] A) {

        if (A.length <= 1) return true;

        boolean foundBeginning = false;
        boolean determinedOrder = false;
        boolean increasing = false;

        int index = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] == A[i]) continue;

            if (A[i + 1] > A[i]) {
                increasing = true;
                break;
            }

            if (A[i + 1] < A[i]) {
                increasing = false;
                break;
            }
        }

        while (index < A.length - 1) {

            if ((increasing && A[index + 1] < A[index]) || (!increasing && A[index + 1] > A[index])) {
                return false;
            }
            index++;
        }

        return true;
    }
}