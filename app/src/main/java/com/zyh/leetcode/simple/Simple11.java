package com.zyh.leetcode.simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Simple11 {
    /**
     * 没什么好说的了 很简单的题
     * 可以看看答案上的二分法
     * 时间为O(logN)
     * @param nums
     * @param target
     * @return
     */


    public int searchInsert(int[] nums, int target) {   //[1,3,5,6] 5
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        int length = nums.length;
        int min = 0, max = length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nums[mid] < target)
                min = mid + 1;
            else max = mid - 1;
        }
        return min;
    }
}
