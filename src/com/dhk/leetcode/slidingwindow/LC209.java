package com.dhk.leetcode.slidingwindow;

// 209. Minimum Size Subarray Sum
// INSIGHTS: Use sliding window to find min length.
// Don't use redundant variable to save space.
public class LC209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        // 2

        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        // 1

        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        // 0
    }

    private static int minSubArrayLen(int target, int[] nums) {
        // default min length is 0 in case no sub array is found
        int minLength = 0;
        // 2 pointers for sliding window
        int left = 0;
        int right = 0;
        // init currentSum as first element of nums
        int currentSum = nums[left];

        while (true) {
            if (currentSum >= target) {
                // calculate length if current sum >= target
                if (minLength == 0) {
                    // init min length
                    minLength = right - left + 1;
                } else {
                    // if min length was init, find min between min length and current length found
                    minLength = Math.min(minLength, right - left + 1);
                }

                if (left < right) {
                    // if left can be moved, we will move left to the right to find potential min length
                    // subtract old value from sum
                    currentSum -= nums[left++];
                } else {
                    // if left cannot be moved, we will move right to the right to continue the search forward
                    // add new value to sum
                    if (right < nums.length - 1) {
                        currentSum += nums[++right];
                    } else {
                        // if right cannot be moved, stop the search
                        break;
                    }
                }
            } else {
                // if sum < target, we will move right to the right to add new value to sum
                if (right < nums.length - 1) {
                    currentSum += nums[++right];
                } else {
                    // if right cannot be moved, stop the search
                    break;
                }
            }
        }

        return minLength;
    }
}

/*
209. Minimum Size Subarray Sum
Medium
        Topics
premium lock icon
        Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
sum is greater than or equal to target. If there is no such subarray, return 0 instead.



        Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is
O(n log(n)).

 */
