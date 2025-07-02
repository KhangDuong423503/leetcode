package com.dhk.leetcode.twopointers;

import java.util.Arrays;

// 88. Merge Sorted Array
// INSIGHTS: copy array 1 and use 2 pointers on copied array and array 2
// to decide which value to update to original array 1 first
public class LC88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{};
        merge(nums3, 1, nums4, 0);
        System.out.println(Arrays.toString(nums3));

        int[] nums5 = new int[]{0};
        int[] nums6 = new int[]{1};
        merge(nums5, 0, nums6, 1);
        System.out.println(Arrays.toString(nums5));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, nums1.length);
        int mi = 0;
        int ni = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (ni >= n || (mi < m && nums1Copy[mi] <= nums2[ni])) {
                nums1[i] = nums1Copy[mi];
                mi++;
            } else {
                nums1[i] = nums2[ni];
                ni++;
            }
        }
    }
}

/*
88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and
the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
        Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
        1 <= m + n <= 200
        -109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?

 */