package com.byon.gorilla.algorithms;


import org.junit.Assert;
import org.junit.Test;

public class DailyTemperatureTest {

    @Test
    public void testTemperature(){
        int [] input = new int[]{73,74,75,71,69,72,76,73};

        int [] result = DailyTemperature.dailyTemperatures(input);

        int [] expected = new int[]{1,1,4,2,1,1,0,0};

        Assert.assertEquals(result, expected);

    }

}
