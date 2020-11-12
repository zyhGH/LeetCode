package com.zyh.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

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
            } else {
                map.put(arr[i], 1);
            }
        }
        HashSet<Integer> set = new HashSet<>(map.values());

        if (map.size() == set.size()) {
            return true;
        } else {
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

class DailyTest7 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> resultSet = new HashSet<Integer>();
        for (int num : set1) {
            if (set2.contains(num)) {
                resultSet.add(num);
            }
        }
        int[] resultArr = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            resultArr[index++] = num;
        }
        return resultArr;
    }
}

class DailyTest8 {
    public boolean validMountainArray(int[] A) {    //  2 1
        int i = 0;
        int j = A.length - 1;

        for (int k = 1; k < A.length; k++) {
            if (A[k] > A[i]) {
                i = k;
            } else {
                break;
            }
        }

        for (int k = A.length - 2; k >= 0; k--) {
            if (A[k] > A[j]) {
                j = k;
            } else {
                break;
            }
        }
        if (i == 0 || j == A.length - 1)
            return false;
        return i == j;
    }
}

class DailyTest9 {
    public int[][] insert(int[][] intervals, int[] newInterval) {   //1,2,3,5,6,7,8,10,12,16   4,8
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;

        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}

class DailyTest10 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        for (int i = 0; i < beginWord.length(); i++) {

        }
        return 0;
    }
}

class DailyTest11 {
    public int[] sortByBits(int[] arr) {
        final int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
}

class DailyTest12 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }
}

class DailyTest13 {
    public static void main(String[] args) {
        nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        Arrays.sort(nums, i + 1, nums.length);
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j]);
        }
    }
}

class DailyTest14 {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (j < A.length) {
                    if (A[j] % 2 == 1) {
                        j += 2;
                    }else {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        j += 2;
                        break;
                    }
                }
            }
        }
        return A;
    }
}