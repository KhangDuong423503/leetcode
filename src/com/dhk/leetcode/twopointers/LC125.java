package com.dhk.leetcode.twopointers;

// 125. Valid Palindrome
// INSIGHTS: Use two pointers from both ends.
// Comparing ASCII values is faster than using built-in functions like toLowerCase() or Character.isLetterOrDigit(char)
public class LC125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(!isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);

            // convert char to lowercase
            if (leftChar >= 'A' && leftChar <= 'Z') {
                leftChar = (char) (leftChar + 32);
            }
            if (rightChar >= 'A' && rightChar <= 'Z') {
                rightChar = (char) (rightChar + 32);
            }

            if (isNotAlphaNumeric(leftChar)) {
                i++;
                continue;
            }
            if (isNotAlphaNumeric(rightChar)) {
                j--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private static boolean isNotAlphaNumeric(char c) {
        return !(c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
}

/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



        Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = "race a car"
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


        Constraints:

        1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

 */
