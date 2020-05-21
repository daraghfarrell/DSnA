package com.darx.arrays;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void calculateGCD() {
        ArrayFoo arrayFoo = new ArrayFoo();
        int a = 12;
        int b = 3;
        Assert.assertTrue(Util.calcGCD(a, b) == 3);
    }
}
