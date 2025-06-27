package com.dhk.leetcode.twopointers;

// 11. Container With Most Water
// INSIGHTS: Use two pointers from both ends.
// We can keep moving the index of min height until a higher value is found.
public class LC11 {
    public static void main(String[] args) {
        int[] height1 = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height1));
        // 49

        int[] height2 = new int[]{1,1};
        System.out.println(maxArea(height2));
        // 1
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int currentArea;
        // two pointers start from both ends
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            currentArea = Math.min(height[left], height[right]) * (right - left);
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            // move the pointer of min height until higher value is found
            boolean isLeftIndexMinHeight = height[left] < height[right];
            if (isLeftIndexMinHeight) {
                int currentMinHeight = height[left];
                while (left < right) {
                    left++;
                    if (height[left] > currentMinHeight) {
                        break;
                    }
                }
            } else {
                int currentMinHeight = height[right];
                while (left < right) {
                    right--;
                    if (height[right] > currentMinHeight) {
                        break;
                    }
                }
            }
        }

        return maxArea;
    }
}

/*
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water
(blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
        0 <= height[i] <= 104

 */
