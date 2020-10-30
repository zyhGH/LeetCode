package com.zyh.leetcode.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Simple19 {

    /**
     * 链表的递归其实就是指针往下移
     * 所以一直是head.next = deleteDuplicates
     * 如果head的val和head.next.val相等
     * 则代表数字有重复
     * 这时可以舍去head
     * head = head.next
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val)
            head = head.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
