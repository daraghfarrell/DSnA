package com.darx.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

public class ArrayFooTest {

    private ArrayFoo arrayFoo;

    @Before
    public void setUp() throws Exception {
        arrayFoo = new ArrayFoo();
    }

    @After
    public void tearDown() throws Exception {
        arrayFoo = null;
    }

    @Test
    public void sumTest() {
        int[] input = {1,2,3,4};
        int expected = 10;
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


    @Test
    public void rotateArrayWithTemp() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        int d = 2;
        int[] expected = {3, 4, 5, 6, 7, 1, 2};
        int[] result;

        result = arrayFoo.rotateArrayWithTemp(n, d, input);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(result));
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void rotateInPlaceByOne() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        int d = 2;
        int[] expected = {3, 4, 5, 6, 7, 1, 2};
        int[] result;

        result = arrayFoo.rotateInPlaceByOne(n, d, input);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(result));
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void rotateLeftByJuggle() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = 12;
        int d = 3;
        int[] expected = {4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3};
        int[] output;

        output = arrayFoo.rotateLeftByJuggle(input, n, d);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(output));
        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void rotateLeftByJuggle2() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int n = 17;
        int d = 3;
        int[] expected = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3};
        int[] output;

        output = arrayFoo.rotateLeftByJuggle(input, n, d);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(output));
        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void rotateLeftByJuggle3() {
        int[] input     = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int n = 20;
        int d = 4;
        int[] expected  = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 3, 4};
        int[] output;

        output = arrayFoo.rotateLeftByJuggle(input, n, d);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(output));
        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void findMaxConsecutiveOnes() {
        int[] input = {1,0,1,1,0,1};
        int result = arrayFoo.findMaxConsecutiveOnes(input);
        Assert.assertEquals(2, result);
    }

    @Test
    public void findMaxConsecutiveOnes1() {
        int[] input = {1};
        int result = arrayFoo.findMaxConsecutiveOnes(input);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findCountOfEvenNumberWithEvenNumberOfDigits() {
        int[] nums = {12,345,2,6,7896};
        Assert.assertEquals(2, arrayFoo.findCountOfEvenNumberWithEvenNumberOfDigits(nums));
    }

    @Test
    public void sortedSquaresV1() {
        int[] input = {-4,-1,0,3,10};
        int[] expected = {0,1,9,16,100};
        Assert.assertArrayEquals(expected, arrayFoo.sortedSquaresV1(input));

        input = new int[] {-7,-3,2,3,11};
        expected = new int[] {4,9,9,49,121};
        Assert.assertArrayEquals(expected, arrayFoo.sortedSquaresV1(input));
    }

    @Test
    public void sortedSquaresV2() {
        int[] input = {-4,-1,0,3,10};
        int[] expected = {0,1,9,16,100};
        Assert.assertArrayEquals(expected, arrayFoo.sortedSquaresV2(input));

        input = new int[] {-7,-3,2,3,11};
        expected = new int[] {4,9,9,49,121};
        Assert.assertArrayEquals(expected, arrayFoo.sortedSquaresV2(input));
    }

    @Test
    public void duplicateZerosWithTemp() {
        int[] input = {1,0,2,3,0,4,5,0};
        int[] expected = {1,0,0,2,3,0,0,4};
        arrayFoo.duplicateZerosTwoLoops(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void duplicateZerosSingleLoop() {
        int[] input = {1,0,2,3,0,4,5,0};
        int[] expected = {1,0,0,2,3,0,0,4};
        arrayFoo.duplicateZerosSingleLoop(input);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(input));
    }

    @Test
    public void mergeTwoSortedArrays() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] expected = {1,2,2,3,5,6};

        arrayFoo.mergeTwoSortedArrays(nums1, 3, nums2, 3);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums1));
    }

    @Test
    public void mergeTwoSortedArrays2() {
        int[] expected = {-1,0,0,1,2,2,3,3,3};
        int[] nums1 = new int[] {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = new int[] {1,2,2};
        arrayFoo.mergeTwoSortedArrays(nums1, 6, nums2, 3);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums1));
    }

    @Test
    public void removeElement() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int result = arrayFoo.removeElement(nums, val);
        Assert.assertEquals(5, result);
    }

    @Test
    public void removeDuplicates() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = arrayFoo.removeDuplicates(nums);
        Assert.assertEquals(5, result);
    }

    @Test
    public void checkIfExist0() {
        int[] arr = {10,2,5,3};
        Assert.assertEquals(true, arrayFoo.checkIfExist(arr));
    }

    @Test
    public void checkIfExist() {
        int[] arr = {7,1,14,11};
        Assert.assertEquals(true, arrayFoo.checkIfExist(arr));

        arr = new int[] {3,1,7,11};
        Assert.assertEquals(false, arrayFoo.checkIfExist(arr));

        arr = new int[] {4,-7,11,4,18};
        Assert.assertEquals(false, arrayFoo.checkIfExist(arr));

    }

    @Test
    public void checkIfExist2() {
        int[] arr = {-2, 0, 10, -19, 4, 6, -8};
        Assert.assertEquals(false, arrayFoo.checkIfExist(arr));
    }

    @Test
    public void checkIfExist3() {
        int[] arr = {0, 0};
        Assert.assertEquals(true, arrayFoo.checkIfExist(arr));
    }

    @Test
    public void validMountainArray1() {
        int[] A = {0,3,2,1};
        Assert.assertEquals(true, arrayFoo.validMountainArray(A));
    }

    @Test
    public void validMountainArray2() {
        int[] A = {1,3,2};
        Assert.assertEquals(true, arrayFoo.validMountainArray(A));
    }

    @Test
    public void validMountainArray3() {
        int[] A = {0,1,2,1,2};
        Assert.assertEquals(false, arrayFoo.validMountainArray(A));
    }

    @Test
    public void validMountainArray4() {
        int[] A = {2,1,2,3,5,7,9,10,12,14,15,16,18,14,13};
        Assert.assertEquals(false, arrayFoo.validMountainArray(A));
    }

    @Test
    public void replaceElements() {
        int[] arr = {17,18,5,4,6,1};
        int[] expected = {18,6,6,6,1,-1};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(arrayFoo.replaceElements(arr)));
    }

    @Test
    public void replaceElements1() {
        int[] arr = {400};
        int[] expected = {-1};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(arrayFoo.replaceElements(arr)));
    }

    @Test
    public void moveZeroes() {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        arrayFoo.moveZeroes2(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void moveZeroes3() {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        arrayFoo.moveZeroes3(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void moveZeroes4() {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        arrayFoo.moveZeroes4(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void sortArrayByParity() {
        int[] nums = {3,1,2,4};
        int[] expected = {4,2,1,3};
        int[] result = arrayFoo.sortArrayByParity(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}