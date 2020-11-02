package com.zyh.leetcode.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class DailyTest1 {
    public boolean isPalindrome(ListNode head) {        // 1->2->2->1
        ListNode temp = head;
        ListNode temp1 = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null && temp1 != null) {
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

class DailyTest2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {    //[8,1,2,2,3]
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    result[i] += 1;
                }
            }
        }
        return result;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {    //[8,1,2,2,3]
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int length = nums.length;
        int[] result = new int[length];
        int[] counter = new int[101];

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : counter[nums[i] - 1];
        }
        return result;
    }
}

class DailyTest3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        function(root, list);
        return list;
    }

    public void function(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            function(root.left, result);
            function(root.right, result);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

class DailyTest4 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int temp = map.get(arr[i]);
                map.put(arr[i], temp + 1);
            }else {
                map.put(arr[i], 1);
            }
        }
        HashSet<Integer> set = new HashSet<>(map.values());

        if (map.size() == set.size()) {
            return true;
        }else {
            return false;
        }

    }
}

class DailyTest5 {
    //    1
    // 2,    3
    //1,2   5,6

    int result = 0;

    public int sumNumbers(TreeNode root) {
        sum(0, root);
        return result;
    }

    public void sum(int val, TreeNode node) {
        if (node == null)
            return;

        int temp = val * 10 + node.val;

        if (node.left == null && node.right == null) {
            result += temp;
        }
        if (node.left != null)
            sum(temp, node.left);
        if (node.right != null)
            sum(temp, node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

class DailyTest6 {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
