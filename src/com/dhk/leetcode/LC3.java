package com.dhk.leetcode;

import java.util.HashMap;

// 3. Longest Substring Without Repeating Characters
// INSIGHTS: use sliding window and HashMap to greedily find the longest local substring without repeated characters,
// update max length as you go
public class LC3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
    }

    private static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int currLength = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(true) {
            if(j >= s.length()) {
                break;
            }

            char currChar = s.charAt(j);
            if(!map.containsKey(currChar)) {
                map.put(currChar, 1);
                currLength++;
                if(currLength > maxLength) {
                    maxLength = currLength;
                }

                j++;
            } else { // abcdecfgh
                while(map.containsKey(currChar)) {
                    if(currChar != s.charAt(i)) {
                        map.remove(s.charAt(i));
                        i++;
                        currLength--;
                    } else {
                        i++;
                        currLength--;
                        break;
                    }
                }
                currLength++;
                j++;
            }
        }

        return maxLength;
    }
}

/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.



        Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


        Constraints:

        0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
