package com.dhk.leetcode;

// 2. Add Two Numbers
// INSIGHTS: process one pair of nodes at a time to avoid number overflow, carry leftover to the next pair of nodes
public class LC2 {
    public static void main(String[] args) {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int leftover) {
        int tempNum = leftover;
        if (l1 == null && l2 == null) {
            if (leftover > 0) {
                return new ListNode(leftover);
            }
            return null;
        }
        if (l1 != null) {
            tempNum += l1.val;
        }
        if (l2 != null) {
            tempNum += l2.val;
        }

        leftover = tempNum / 10;
        ListNode next1 = l1 == null ? null : l1.next;
        ListNode next2 = l2 == null ? null : l2.next;
        return new ListNode(tempNum % 10, addTwoNumbers(next1, next2, leftover));
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



        Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

 */
