package com.darx.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayFoo {

    public int[] copyTo(int[] original, int[] targetCopy) {
        for (int i = 0; i < original.length; i++) {
            targetCopy[i] = original[i];
        }
        return targetCopy;
    }

    public int sum(int[] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result += input[i];
        }
        return result;
    }

    /**
     * Time complexity O(n) - for loop up and insertion
     * Space Complexity O(count) - number of elements in additional array
     */
    public int[] rotateArrayWithTemp(int size, int count, int[] input) {
        int[] tempArray = new int[count];

        // move the count number of elements to temp array
        for (int i = 0; i < count; i++) {
            tempArray[i] = input[i];
        }

        // move all remaining elements count steps left
        for (int j = count; j < input.length; j++) {
            input[j - count] = input[j];
        }

        // copy temp elements back on end of input array
        // walk both arrays using temp array index
        for (int p = 0; p < tempArray.length; p++) {
            input[size - count + p] = tempArray[p];
        }
        return input;
    }

    /**
     * Time complexity : O(n * count) -- n for traversing array length, count for number of rotations
     * Auxiliary Space : O(1) -- for temp variable
     */
    public int[] rotateInPlaceByOne(int size, int count, int[] input) {
        // create a temp variable
        int temp;

        // rotate count times
        for (int i = 0; i < count; i++) {
            rotateLeftByOne(input, size);
        }
        return input;
    }

    private void rotateLeftByOne(int[] input, int size) {
        int temp;// store an element in temp
        temp = input[0];

        // rotate elements to left
        for (int j = 1; j < size; j++) {
            input[j - 1] = input[j];
        }

        // return stored element to end
        input[input.length - 1] = temp;
    }


    /**
     *
     */
    public int[] rotateLeftByJuggle(int[] inputArray, int numberOfElements, int numberOfMoves) {

        // calc gdc
        int gdc = Util.calcGCD(numberOfElements, numberOfMoves);

        // temp for holding the element being moved
        int temp;

        // loop through the array by sets up to GDC
        for (int start = 0; start < gdc; start++) {

            // grab the first element and store in temp
            temp = inputArray[start];

            // set the empty spot to the first element in set because we just copied it into temp
            int empty = start;

            // loop through set, initial element defined by empty
            while (true) {

                // move forward
                int next = empty + numberOfMoves;

                // check for end of array
                if (next >= numberOfElements)
                    // step back by number of elements
                    next = next - numberOfElements;

                // check if we are back at start
                if (next == start)
                    // break loop
                    break;

                // move elements by one step
                inputArray[empty] = inputArray[next];

                // next is assigned to empty, rinse and repeat
                empty = next;
            }

            // put temp into the last j position
            inputArray[empty] = temp;
        }

        return inputArray;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;

        for (int i = 0; i < nums.length; i++) {
            // if 1 then increment
            if (nums[i] == 1) {
                currentMax++;
            }

            // if local max is greater copy
            if (currentMax > max) {
                max = currentMax;
            }

            // if we hit a zero reset
            if (nums[i] == 0) { // we hit a zero
                currentMax = 0;
            }
        }
        return max;
    }

    public int findCountOfEvenNumberWithEvenNumberOfDigits(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (Integer.toString(element).toCharArray().length % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int[] sortedSquaresV1(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * Optimal
     */
    public int[] sortedSquaresV2(int[] A) {
        int[] output = new int[A.length];

        int start = 0,
                end = A.length - 1,
                next = output.length - 1; // write back from end

        while (start <= end) {
            // start val > end eval
            // largest -ve number or largest number
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                output[next] = A[start] * A[start];
                start++;
            } else {
                output[next] = A[end] * A[end];
                end--;
            }

            next--;
        }
        return output;
    }

    /**
     * uses two loop
     * Time: O(2n)
     * Space: O(n)
     */
    public void duplicateZerosTwoLoops(int[] arr) {
        int[] output = new int[arr.length];
        int next = 0;

        for (int i = 0; i < arr.length && next < output.length; i++) {
            if (arr[i] != 0) {
                output[next] = arr[i];
                next++;
            } else {
                output[next] = arr[i];
                next++;

                if (next < output.length) {
                    output[next] = 0;
                    next++;
                }
            }
        }

        // copy array
        for (int j = 0; j < output.length; j++) {
            arr[j] = output[j];
        }
    }

    /**
     * use a single loop
     * Time: O(n)
     * Space: O(n)
     */
    public void duplicateZerosSingleLoop(int[] arr) {
        int origIndex = 0;
        int dupIndex = 0;
        int[] dup = Arrays.copyOf(arr, arr.length);

        // loop thru dup
        // rewrite values back to arr adding a zero when we find one
        while (dupIndex < dup.length) {

            // hit zero
            if (dup[dupIndex] == 0 && origIndex < arr.length) {

                // write the value from dup to orig
                arr[origIndex] = dup[dupIndex];

                // increment
                origIndex++;

                // if not off the end write the additional zero
                if (origIndex < arr.length) {
                    arr[origIndex] = 0;
                }

            }

            // not zero copy values
            else {
                if (origIndex < arr.length) {
                    arr[origIndex] = dup[dupIndex];
                }
            }

            // step forward both arrays
            origIndex++;
            dupIndex++;
        }
    }

    /**
     *
     */
    public void mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        // dup first n elements from Nums1
        int[] dup = Arrays.copyOf(nums1, m);

        // merge sort nums1 and nums2 into nums1
        int iNums1 = m + n - 1;
        int iDup = m - 1;
        int iNums2 = n - 1;

        // loop thru both arrays
        while (iDup >= 0 || iNums2 >= 0) {

            if (iDup >= 0 && iNums2 >= 0 && dup[iDup] > nums2[iNums2]) {
                nums1[iNums1--] = dup[iDup--];
            }

            if (iDup >= 0 && iNums2 >= 0 && dup[iDup] < nums2[iNums2]) {
                nums1[iNums1--] = nums2[iNums2--];
            }

            if (iDup >= 0 && iNums2 >= 0 && dup[iDup] == nums2[iNums2]) {
                nums1[iNums1--] = dup[iDup--];
                nums1[iNums1--] = nums2[iNums2--];
            }

            if (iDup >= 0 && iNums2 < 0) {
                nums1[iNums1--] = dup[iDup--];
            }

            if (iDup < 0 && iNums2 >= 0) {
                nums1[iNums1--] = nums2[iNums2--];
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int temp = 0;
        int read = 0;
        int write = 0;

        // traverse array
        while (read < nums.length) {

            // inspect values
            temp = nums[read];

            // if match, skip write
            if (temp == val) {
                length--;
            } else { // write back
                nums[write] = temp;
                write++;
            }

            read++;
        }

        return length;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int len = nums.length;
        int reader = 1;
        int writer = 0;

        while (reader < nums.length) {
            // if prev and curr are same - dup
            if (nums[writer] == nums[reader]) {
                len--; // reduce length
            } else {
                // different so move forward and write the new value
                writer++;
                nums[writer] = nums[reader];
            }

            // always read next until we are done
            reader++;
        }

        return len;
    }

    public boolean checkIfExist(int[] arr) {

        // create map of unique doubled values
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(Integer.valueOf(2 * arr[i]), Integer.valueOf(i));
        }

        // traverse array & check for matches
        for (int j = 0; j < arr.length; j++) {
            Integer current = Integer.valueOf(arr[j]);

            // for each value, check if it has a double with a different index
            if (map.containsKey(current)) {
                Integer valueIndex = (Integer) map.get(current);
                if (valueIndex != null && valueIndex.intValue() != j) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validMountainArray(int[] A) {
        if (!(A.length >= 3)) {
            return false;
        }

        boolean isMountain = false;
        int max = 0; // max peak
        boolean upward = true; // assume initially
        int prev = A[0];

        for (int i = 1; i < A.length; i++) {
            int curr = A[i];

            // upward
            if (upward && prev < curr) {
                max = curr;
            }

            // peak
            else if (max != 0 && upward && prev > curr) {
                upward = false;
                isMountain = true;
            }

            // plateau
            else if (prev == curr) {
                isMountain = false;
            }

            // downward & second peak
            else if (!upward && prev <= curr) {
                isMountain = false;
            }

            // start downward
            else if (max == 0 && prev > curr) { // starts on downward
                isMountain = false;
                break;
            }

            prev = curr;
        }

        return isMountain;
    }

    /**
     * Neat solution
     *
     * @param A
     * @return
     */
    public boolean validMountainArray2(int[] A) {
        if (A == null || A.length < 3) return false;
        int length = A.length;
        int start = 0;

        // Go up
        while (start + 1 < length && A[start] < A[start + 1]) start++;

        // Peak can't be first or last
        if (start == 0 || start == length - 1) return false;

        // Go down
        while (start + 1 < length && A[start] > A[start + 1]) start++;
        return start == length - 1;
    }

    /**
     * O(n^2)
     * need to walk backwards
     */
    public int[] replaceElements1(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        // for each element
        for (int i = 0; i < arr.length; i++) {
            int largest = -1;

            // search for largest to the right
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > largest)
                    largest = arr[j];
            }

            // overwrite with largest
            arr[i] = largest;
        }

        arr[arr.length - 1] = -1;

        return arr;
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {

            // grab temp
            int temp = arr[i];

            // write max
            arr[i] = max;

            // evaluate new max
            if (temp > max)
                max = temp;
        }

        return arr;
    }

    public void moveZeroes2(int[] nums) {
        int read = 0;
        int write = 0;
        int count = 0;

        while (read < nums.length) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
                count++;
            }

            read++;
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int read = 0;
        int write = 0;
        int count = 0;

        while (read < nums.length) {
            if (nums[read] != 0) {
                int temp = nums[write];
                nums[write] = nums[read];
                nums[read] = temp;
                write++;
                count++;
            }
            read++;
        }
    }

    public void moveZeroes4(int[] nums) {
        int read = 0;
        int write = 0;
        int count = 0;

        while (read < nums.length) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                nums[read] = 0;
                write++;
                count++;
            }
            read++;
        }
    }

    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            // start odd, end even
            if (A[start] % 2 != 0 && A[end] % 2 == 0) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;

                start++;
                end--;
            }

            // start even, end odd
            else if (A[start] % 2 == 0 && A[end] % 2 == 0) {
                start++;
            }

            // both odd
            else {
                end--;
            }
        }

        return A;
    }
}