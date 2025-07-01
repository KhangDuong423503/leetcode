package com.dhk.leetcode.hashmap;

import java.util.HashMap;

// 594. Longest Harmonious Subsequence
// INSIGHTS: We only need to check if key "value + 1" exists, checking "value - 1" is redundant
// Iterating through key set is slightly faster than entry set in this case
public class LC594 {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
        // 5

        System.out.println(findLHS(new int[]{1,2,3,4}));
        // 2

        System.out.println(findLHS(new int[]{1,1,1,1}));
        // 0
    }

    private static int findLHS(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer> valueOccurrenceMap = new HashMap<>();

        // use Hash Map to store value occurrences
        for (int currentValue : nums) {
            if (valueOccurrenceMap.containsKey(currentValue)) {
                valueOccurrenceMap.put(currentValue, valueOccurrenceMap.get(currentValue) + 1);
            } else {
                valueOccurrenceMap.put(currentValue, 1);
            }
        }

        // iterate through Hash Map to find max length
        for (int value : valueOccurrenceMap.keySet()) {
            if (valueOccurrenceMap.containsKey(value + 1)) {
                maxLength = Math.max(maxLength, valueOccurrenceMap.get(value) + valueOccurrenceMap.get(value + 1));
            }
        }

        return maxLength;
    }
}

/*
594. Longest Harmonious Subsequence

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.



Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]

Output: 2

Explanation:

The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:

Input: nums = [1,1,1,1]

Output: 0

Explanation:

No harmonic subsequence exists.



Constraints:

        1 <= nums.length <= 2 * 104
        -109 <= nums[i] <= 109

 */
