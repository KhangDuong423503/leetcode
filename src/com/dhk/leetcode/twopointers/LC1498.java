package com.dhk.leetcode.twopointers;

import java.util.Arrays;

// 1498. Number of Subsequences That Satisfy the Given Sum Condition
// INSIGHTS: You can pre-compute 2^n mod 10^9 + 7 to avoid using BigInteger.
// The number of subsequences that includes nums[left] and any subset of (right - left) elements are valid => 2^(right-left).
public class LC1498 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,5,6,7};
        System.out.println(numSubseq(nums1, 9));
        // 4

        int[] nums2 = new int[]{3,3,6,8};
        System.out.println(numSubseq(nums2, 10));
        // 6

        int[] nums3 = new int[]{2,3,3,4,6,7};
        System.out.println(numSubseq(nums3, 12));
        // 61

        int[] nums4 = new int[]{27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,
                28,2,14,22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22};
        System.out.println(numSubseq(nums4, 31));
        // 688052206
    }

    private static int numSubseq(int[] nums, int target) {
        // Dual-Pivot Quicksort
        Arrays.sort(nums);

        int result = 0;
        int mod = 1000000007;
        int numsSize = nums.length;
        // pre-compute 2^n mod 10^9 + 7
        int[] twoPowerOfN = new int[numsSize];
        twoPowerOfN[0] = 1;
        for (int i = 1; i < numsSize; i++) {
            twoPowerOfN[i] = (twoPowerOfN[i - 1] * 2) % mod;
        }
        // two pointers
        int left = 0;
        int right = numsSize - 1;

        // repeat until left pointer is to the right of right pointer
        while (left <= right) {
            // move right pointer left if target is exceeded
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }

            // add 2^(right-left) to the result and mod 10^9 + 7 to avoid overflowing new result
            result = (result + twoPowerOfN[right - left]) % mod;
            // move left pointer right otherwise
            left++;
        }

        return result;
    }
}

/*
1498. Number of Subsequences That Satisfy the Given Sum Condition

You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less
or equal to target. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
        [3,5,6] -> (3 + 6 <= 9)
        [3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
        [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).


Constraints:

        1 <= nums.length <= 105
        1 <= nums[i] <= 106
        1 <= target <= 106

 */
