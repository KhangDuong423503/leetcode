package com.dhk.leetcode.math;

// 3304. Find the K-th Character in String Game I
// INSIGHTS: Use 2^n to quickly jump to k, then count the number of subtractions until 1 to get the number of changes made to 'a'.
public class LC3304 {
    private static final int[] twoPowerOfN = {
            1, 2, 4, 8, 16, 32, 64, 128, 256, 512
    };

    public static void main(String[] args) {
        System.out.println(kthCharacter(1));
        // a

        System.out.println(kthCharacter(5));
        // b

        System.out.println(kthCharacter(10));
        // c

        System.out.println(kthCharacter(500));
        // h
    }

    private static char kthCharacter(int k) {
        int count = 0;

        while (k > 1) {
            for (int i = 0; i < twoPowerOfN.length; i++) {
                if (twoPowerOfN[i] >= k) {
                    // If a two power of n is found to be >= k, we subtract 2^(n-1) from it,
                    // in order to count how many times we have to do that to reach 1 (first position where 'a' is)
                    k -= twoPowerOfN[i - 1];
                    count++;
                    break;
                }
            }
        }

        // The amount of times we had to subtract is also the amount of times 'a' is changed.
        // Since the constraint is 1 <= k <= 500, 'z' will never be reached, so we don't have to check to loop back.
        return (char) ('a' + count);
    }
}

/*
3304. Find the K-th Character in String Game I

Alice and Bob are playing a game. Initially, Alice has a string word = "a".

You are given a positive integer k.

Now Bob will ask Alice to perform the following operation forever:

Generate a new string by changing each character in word to its next character in the English alphabet, and append it to
the original word.

For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, after enough operations have been done for word to have at least k
characters.

Note that the character 'z' can be changed to 'a' in the operation.



        Example 1:

Input: k = 5

Output: "b"

Explanation:

Initially, word = "a". We need to do the operation three times:

Generated string is "b", word becomes "ab".
Generated string is "bc", word becomes "abbc".
Generated string is "bccd", word becomes "abbcbccd".
Example 2:

Input: k = 10

Output: "c"



Constraints:

        1 <= k <= 500

 */
