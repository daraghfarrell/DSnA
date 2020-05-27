package com.darx.queues;

import java.util.ArrayList;

class MovingAverage {
    int maxSize;
    int currSize;
    ArrayList<Integer> list = new ArrayList(10);
    int head = 0;
    int tail = 0;
    double currAvg = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.maxSize = size;
    }

    public double next(int val) {
        list.add(val);
        currSize++;

        if(currSize <= maxSize) {
            tail++;
        } else {
            tail++;
            head++;
        }

        calcNewAvg();
        return currAvg;
    }

    public void calcNewAvg() {
        double runningTot = 0;
        for(int i = head; i < tail; i++) {
            runningTot += list.get(i);
        }

        currAvg = runningTot/currSize;
    }
}
