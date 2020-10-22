package com.zyh.leetcode.simple;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Simple3 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(1222222221));
    }

    /**
     * func2 比 func1好的地方 我认为
     * 循环次数少了
     * 2要循环一半就行了 1要循环全部
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int tempX = x;
        int y = 0;
        while(tempX != 0) {
            int value = tempX % 10;
            tempX /= 10;
            y = y * 10 + value;
        }

        if(y == x) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {
        if(x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int tempX = x;
        int y = 0;
        while(tempX > y) {  //1221
            int value = tempX % 10;
            tempX /= 10;
            y = y * 10 + value;
        }
        System.out.println(y);
        System.out.println(tempX);
        if ((y / 10 == tempX || y == tempX) && x % 10 != 0) {
            return true;
        }else {
            return false;
        }
    }
}
