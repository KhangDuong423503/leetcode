package com.dhk.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3Sum
// INSIGHTS: Just move pointer if same value to avoid duplicates
public class LC15 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,1,2,-1,-4}; // -4, -1, -1, 0, 1, 2
        System.out.println(threeSum(nums1));
        // [[-1,-1,2],[-1,0,1]]

        int[] nums2 = new int[]{0,1,1};
        System.out.println(threeSum(nums2));
        // []

        int[] nums3 = new int[]{0,0,0};
        System.out.println(threeSum(nums3));
        // [[0,0,0]]
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        // sort array
        Arrays.sort(nums);

        // iterate through sorted array
        for (int i = 0; i < nums.length - 2; i++) {
            // ignore past elements to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // for each element, use two pointers to find the remaining 2 elements (0 or more potential matches)
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // ignore past elements to avoid duplicates
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return list;
    }
}

/*
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105

 */
