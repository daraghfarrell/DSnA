package com.darx.search;

public class BinarySearchFoo {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int pivot;

        while(left <= right) {
            pivot = left + (right - left) / 2;

            if(target == nums[pivot])  {
                return pivot;
            }

            if(target < nums[pivot]) {
                right = pivot - 1;
            }
            else { // target > nums[mid]
                left = pivot + 1;
            }

        }

        return -1;
    }
}
