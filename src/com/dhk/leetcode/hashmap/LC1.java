package com.dhk.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;

// 1. Two Sum
// INSIGHTS: use HashMap and check past value as you update it (1 for loop)
public class LC1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums1, 9)));

        int[] nums2 = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum(nums2, 6)));

        int[] nums3 = new int[]{3,3};
        System.out.println(Arrays.toString(twoSum(nums3, 6)));
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if target - value is found, return current index and stored index
            int numToFind = target - nums[i];
            if (valueIndexMap.containsKey(numToFind)) {
                return new int[]{i, valueIndexMap.get(numToFind)};
            } else {
                valueIndexMap.put(nums[i], i);
            }
        }

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        return new int[]{-1, -1};
    }

    // NOT USED
    private static void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

/*
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



        Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
Only one valid answer exists.


        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

 */
