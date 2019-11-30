package com.byon.gorilla.algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SortColorsTest {

    @Test
    public void testSortColors(){
        int [] input = new int[]{2,0,2,1,1,0};
        int [] expected = new int[]{0,0,1,1,2,2};
        SortColors.sortColors(input);

        assertThat(input).isEqualTo(expected);
    }

}