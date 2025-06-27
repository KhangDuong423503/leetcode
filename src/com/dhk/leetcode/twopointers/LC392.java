package com.dhk.leetcode.twopointers;

// 392. Is Subsequence
// INSIGHTS: toCharArray() is slightly faster than iterating charAt(i).
// We can stop the loop early if either pointer reaches the end.
public class LC392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(!isSubsequence("axc", "ahbgdc"));
        System.out.println(!isSubsequence("b", "c"));
        System.out.println(isSubsequence("", "ahbgdc"));
        System.out.println(!isSubsequence("abc", ""));
        System.out.println(isSubsequence("", ""));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            // empty string is always a subsequence
            return true;
        }

        char[] shortCharArray = s.toCharArray();
        char[] longCharArray = t.toCharArray();

        byte i = 0;
        short j = 0;

        while (i < shortCharArray.length && j < longCharArray.length) {
            // increment 1st index (shorter string) when chars at 1st and 2nd indices are the same
            if (shortCharArray[i] == longCharArray[j]) {
                i++;
            }
            j++;
        }

        // is subsequence if 1st index is past the end
        return i == shortCharArray.length;


        // Using toCharArray + string builder gives 0ms runtime
//        char[] char1 = s.toCharArray();
//        char[] char2 = t.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        int j = 0;
//        while (i < char1.length && j < char2.length) {
//            if (char2[j] != char1[i]) {
//                j++;
//            } else {
//                sb.append(char2[j]);
//                i++;
//                j++;
//            }
//
//        }
//
//        String temp = sb.toString();
//
//        if (temp.equals(s)) {
//            return true;
//        }
//
//        return false;
    }
}

/*
392. Is Subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of
"abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

        0 <= s.length <= 100
        0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to
see if t has its subsequence. In this scenario, how would you change your code?

 */
