package com.dhk.leetcode.string;

// 3330. Find the Original Typed String I
// INSIGHTS: just count the amount of duplicates, then plus one in case there is no mistake
public class LC3330 {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        // 5

        System.out.println(possibleStringCount("abcd"));
        // 1

        System.out.println(possibleStringCount("aaaa"));
        // 4
    }

    private static int possibleStringCount(String word) {
        // start at 1 to count the possibility of no mistake
        int result = 1;

        // in case of one mistake, add 1 to count every time a char is the same as the next char
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                result++;
            }
        }

        return result;
    }
}

/*
3330. Find the Original Typed String I

Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for
too long, resulting in a character being typed multiple times.

Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.

You are given a string word, which represents the final output displayed on Alice's screen.

Return the total number of possible original strings that Alice might have intended to type.



        Example 1:

Input: word = "abbcccc"

Output: 5

Explanation:

The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

Example 2:

Input: word = "abcd"

Output: 1

Explanation:

The only possible string is "abcd".

Example 3:

Input: word = "aaaa"

Output: 4



Constraints:

        1 <= word.length <= 100
word consists only of lowercase English letters.

 */
