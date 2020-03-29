package com.byon.gorilla.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MaxOpt1 {

    class Region {
        int start;
        int end;

        public Region(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxRepOpt1(String text) {
        //count
        //assign region in region list
        // if end of list -> dont check past end
        // region -> region end + 1 (neighbor) -> neighbor + 1
        //  if region == neighbor + 1

        // if there exists more outside the two regions -> result+= regions added together + 1
        // else result += regions added together - 1


        int[] map = new int[26];

        List<Region> regions = new ArrayList();

        for (int i = 0; i < text.length(); i++) {
            map[text.charAt(i) - 'a']++;
        }

        for (int i = 0; i < text.length(); i++) {
            int start = i;
            while (start < text.length() && text.charAt(start) == text.charAt(i)) start++;

            regions.add(new Region(i, start));
            i = start - 1;

        }

        int total = 0;

        for (int i = 0; i < regions.size(); i++) {
            int result = 0;
            int size = 0;

            if (i < regions.size() - 2) {
                Region next = regions.get(i + 2);
                if (next.start == regions.get(i).end + 1
                        && text.charAt(next.start) == text.charAt(regions.get(i).start)) {
                    size = next.end - next.start + regions.get(i).end - regions.get(i).start;
                } else {
                    size = regions.get(i).end - regions.get(i).start;
                }

            } else {
                size = regions.get(i).end - regions.get(i).start;
            }

            if (map[text.charAt(regions.get(i).start) - 'a'] > size) {
                result = size + 1;
            } else {
                result = size - 1;
            }

            total = Math.max(total, result);
        }
        return total;
    }

    public static void main(String[] args) {
        MaxOpt1 runner = new MaxOpt1();

        System.out.println(runner.maxRepOpt1("ababa"));
    }
}
