package com.byon.gorilla.sample;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.when;

public class SampleTest {

    @Test
    public void sample_test_success(){
        Assert.assertEquals(23, Integer.sum(2, 21));
    }

}
