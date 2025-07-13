package com.dhk.leetcode.array;

// 169. Majority Element
// INSIGHTS: You can make use of the fact majority element occurs more than n/2 times in the array and write an
// algorithm to check with O(n) time and O(1) space without having to use a hash map.
public class LC169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3})); // 3
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
    }

    private static int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            // return first element for size <= 2, since the majority element always exists
            return nums[0];
        }

        int majorityDifference = 0;
        int result = 0;

        for (int currentElement : nums) {
            if (majorityDifference == 0) {
                // update current element as the result when there is no majority difference,
                // this means there was no guaranteed majority element before this element
                result = currentElement;
            }

            if (currentElement == result) {
                // increase majority difference when there is a streak of the same element
                majorityDifference++;
            } else {
                // decrease majority difference when the streak of same element is broken
                majorityDifference--;
            }
        }

        // the final result will always be the majority element, because it occurs more than n/2 times in the array
        return result;


//        if (nums.length == 1) {
//            // return only element
//            return nums[0];
//        }
//
//        HashMap<Integer, Integer> elementOccurrenceMap = new HashMap<>();
//
//        for (int currentElement : nums) {
//            if (elementOccurrenceMap.containsKey(currentElement)) {
//                // update new occurrence
//                int newOccurrence = elementOccurrenceMap.get(currentElement) + 1;
//                if (newOccurrence > nums.length / 2) {
//                    // return element if it's now a majority
//                    return currentElement;
//                }
//                elementOccurrenceMap.put(currentElement, newOccurrence);
//            } else {
//                // add new element with occurrence 1
//                elementOccurrenceMap.put(currentElement, 1);
//            }
//        }
//
//        return Integer.MIN_VALUE;
    }
}

/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

        n == nums.length
        1 <= n <= 5 * 10^4
        -10^9 <= nums[i] <= 10^9


Follow-up: Could you solve the problem in linear time and in O(1) space?

 */
