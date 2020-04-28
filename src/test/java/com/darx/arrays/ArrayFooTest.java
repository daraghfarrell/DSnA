package com.darx.arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArrayFooTest {

    @Test
    public void sumTest() {
        int[] input = {1,2,3,4};
        int expected = 10;
        ArrayFoo arrayFoo = new ArrayFoo();
        int output = arrayFoo.sum(input);
        Assert.assertEquals(expected, output);

    }

    @Test
    public void copyTest() {
        int[] intArray1 = {1,2,3};
        int[] intArray2 = new int[3];

        ArrayFoo arrayFoo = new ArrayFoo();
        int[] result = arrayFoo.copyTo(intArray1, intArray2);
        int[] expected = {1,2,3};

        Assert.assertArrayEquals(expected, result);
        Assert.assertTrue(result != expected);
    }
}