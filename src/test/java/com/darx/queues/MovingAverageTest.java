package com.darx.queues;

import org.junit.Assert;
import org.junit.Test;


public class MovingAverageTest {

    @Test
    public void next() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assert.assertEquals(1, movingAverage.next(1), 0.01);
        Assert.assertEquals(5.5, movingAverage.next(10), 0.01);
        Assert.assertEquals(4.66, movingAverage.next(3), 0.01);
        Assert.assertEquals(6, movingAverage.next(5), 0.01);
    }
}