package com.dhk.leetcode.array;

import java.util.Arrays;

// 27. Remove Element
// INSIGHTS: swap value found to the back of the array and fill towards the left,
// until swapping wouldn't put the value to the right anymore
public class LC27 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,2,3};
        System.out.println(removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums2, 2));
        System.out.println(Arrays.toString(nums2));
    }

    private static int removeElement(int[] nums, int val) {
        int indexToSwap = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            // value is found
            if (nums[i] == val) {
                // swap with end position and re-adjust "end" index
                if (indexToSwap > i) {
                    int tempNum = nums[i];
                    nums[i] = nums[indexToSwap];
                    nums[indexToSwap] = tempNum;
                    indexToSwap--;
                    i--;
                // return "end" index + 1 as num of elements if the upcoming swap would put the value to the left
                } else if (indexToSwap < i) {
                    return indexToSwap + 1;
                // return "end" index as num of elements if the upcoming swap would put the value in the same place
                } else {
                    return indexToSwap;
                }
            }
        }

        // if the value is not found in the array, return array size as num of elements
        return nums.length;
    }
}

/*
27. Remove Element

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the
elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following
things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The
remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
// It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
        }
If all assertions pass, then your solution will be accepted.



        Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

        0 <= nums.length <= 100
        0 <= nums[i] <= 50
        0 <= val <= 100
 */
