package com.dhk.leetcode.priorityqueue;

import java.util.*;

// 2099. Find Subsequence of Length K With the Largest Sum
// INSIGHTS: Use Hash Map and Max Priority Queue
// I created an empty array to keep everything O(n) at the end without having to sort the indices
public class LC2099 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,1,3,3};
        System.out.println(Arrays.toString(maxSubsequence(nums1, 2)));
        // [3,3]

        int[] nums2 = new int[]{-1,-2,3,4};
        System.out.println(Arrays.toString(maxSubsequence(nums2, 3)));
        // [-1,3,4]

        int[] nums3 = new int[]{3,4,3,3};
        System.out.println(Arrays.toString(maxSubsequence(nums3, 2)));
        // [3,4]
    }

    private static int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        int[] blankArr = new int[nums.length];
        Arrays.fill(blankArr, Integer.MIN_VALUE);
        int[] outputArr = new int[k];
        HashMap<Integer, Queue<Integer>> valueIndexMap = new HashMap<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        // add all elements to a Max Priority Queue
        // also add <value, index> to a Hash Map
        for (int i = 0; i < nums.length; i++) {
            maxQueue.add(nums[i]);

            if (valueIndexMap.containsKey(nums[i])) {
                valueIndexMap.get(nums[i]).add(i);
            } else {
                Queue<Integer> indexQueue = new LinkedList<>();
                indexQueue.add(i);
                valueIndexMap.put(nums[i], indexQueue);
            }
        }

        // poll k times to get the unordered elements
        // only add elements from polled value to the "blank" array based on index found in map
        for (int i = 0; i < k; i++) {
            int currentMaxValue = maxQueue.poll();
            int currentIndex = valueIndexMap.get(currentMaxValue).poll();
            blankArr[currentIndex] = currentMaxValue;
        }

        // iterate through the "blank" array and add the non-blank values to the output array
        int currentIndex = 0;
        for (int j : blankArr) {
            if (j != Integer.MIN_VALUE) {
                outputArr[currentIndex] = j;
                currentIndex++;
            }
        }

        return outputArr;
    }


}

/*
2099. Find Subsequence of Length K With the Largest Sum

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the
largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the
order of the remaining elements.



Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation:
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7.
Another possible subsequence is [4, 3].


Constraints:

        1 <= nums.length <= 1000
        -105 <= nums[i] <= 105
        1 <= k <= nums.length

 */
