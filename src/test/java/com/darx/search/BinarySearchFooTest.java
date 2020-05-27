package com.darx.search;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchFooTest {

    @Test
    public void search() {
        int[] input = {-1,0,3,5,9,12};
        BinarySearchFoo binarySearchFoo = new BinarySearchFoo();
        Assert.assertTrue(-1 != binarySearchFoo.search(input, 9));
        Assert.assertEquals(4, binarySearchFoo.search(input, 9));
    }

    @Test
    public void search1() {
        int[] input = {-1,0,3,5,9,12};
        BinarySearchFoo binarySearchFoo = new BinarySearchFoo();
        Assert.assertEquals(-1, binarySearchFoo.search(input, 2));
    }
}