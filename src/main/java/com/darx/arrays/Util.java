package com.darx.arrays;

public class Util {

    public static int calcGCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return calcGCD(b, a % b);
    }
}
