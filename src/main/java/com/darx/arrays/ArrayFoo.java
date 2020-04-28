package com.darx.arrays;

public class ArrayFoo {

    public int[] copyTo(int[] original, int[] targetCopy) {
        for (int i = 0; i < original.length; i++) {
            targetCopy[i] = original[i];
        }
        return targetCopy;
    }

    public int sum(int[] input) {
        int result = 0;

        for(int i = 0; i < input.length; i++) {
            result += input[i];
        }

        return result;
    }
}
