package com.zyh.leetcode.simple;

import java.util.Stack;

class DailyTest1 {
    public boolean isPalindrome(ListNode head) {        // 1->2->2->1
        ListNode temp = head;
        ListNode temp1 = head;
        Stack<Integer> stack = new Stack<>();
        while(temp != null && temp1 != null) {
            stack.push(temp.val);
            temp = temp.next;
            temp1 = temp.next.next;
        }

        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
