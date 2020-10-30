package com.zyh.leetcode.simple;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple18 {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }


    /**
     * 递归不行的 计算数字小的还行 大的会超出限制
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n != 1 && n != 2) {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }else if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }else {
            return 0;
        }
    }

    /**
     * 原来这个叫动态规划？算法书还没看完
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int j = 1;
        int k = 2;

        for (int i = 3; i < n; i++) {
            int temp = j + k;
            j = k;
            k = temp;
        }
        return j + k;
    }
}
