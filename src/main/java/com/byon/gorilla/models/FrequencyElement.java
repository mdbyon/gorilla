package com.byon.gorilla.models;

public class FrequencyElement implements Comparable<FrequencyElement> {

   public int val;
   public int frequency;

    public FrequencyElement(int val, int frequency) {
        this.val = val;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(FrequencyElement other) {
        if(this.frequency > other.frequency) return 1;
        if(this.frequency < other.frequency) return -1;
        return 0;
    }
}
