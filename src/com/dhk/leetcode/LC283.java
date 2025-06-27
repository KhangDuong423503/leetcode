package com.dhk.leetcode;

import java.util.Arrays;

// 283. Move Zeroes
// INSIGHTS: Use two pointers, traverse the array with i first to swap non-zero elements to update index,
// after that, traverse array starting from update index to fill the rest with zeros.
// Doing this will avoid swapping operations, which will minimize the number of operations.
// Using for each loop is slightly faster.
public class LC283 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,0,3,12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
        // [1,3,12,0,0]

        int[] nums2 = new int[]{0};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
        // [0]
    }

    // 3, 0, 0, 2
    private static void moveZeroes(int[] nums) {
        short updateIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[updateIndex] = num;
                updateIndex++;
            }
        }

        for (; updateIndex < nums.length; updateIndex++) {
            nums[updateIndex] = 0;
        }

        // somehow 0ms runtime
//        int j = 0;
//        for(int i = 0; i < nums.length ; i++)
//        {
//            while( i < nums.length-1 && nums[i] == 0)
//            {
//                j += 1;
//                i += 1;
//            }
//            nums[i-j] = nums[i];
//        }
//        for (int i = 0; i < j ; i++)
//        {
//            nums[nums.length -1 -i] = 0;
//        }
    }
}

/*
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?

 */
