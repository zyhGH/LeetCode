package com.zyh.leetcode.simple;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple7 {
    public static void main(String[] args) {

    }


    /**
     * 这道题看不懂 答案也看不懂
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {   //[1,2,4]  [1,3,4]
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1; //1--- -1,1,2,4       3---2,4      5---4
                l1 = l1.next;
            } else {
                prev.next = l2; //2--- -1,1,3,4       4---3,4      6---4
                l2 = l2.next;
            }
            prev = prev.next;   //1--- 1,2,4  2--- 1,3,4  3--- 2,4  4---3,4   5---4   6---4
        }
        return prehead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
