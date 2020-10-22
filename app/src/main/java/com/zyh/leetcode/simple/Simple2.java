package com.zyh.leetcode.simple;

import android.util.Log;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Simple2 {
    public static void main(String[] args) {
        System.out.println(reverse(121));
    }

    /**
     * 正常解法应该是判断rev有没有大于Integer.Max
     * 但是当rev超过int的最大值时 强转为int就与rev原本值不相等
     * 所以该解法更好
     * @param x
     * @return
     */
    private static int reverse(int x) {
        long rev = 0;
        while(x != 0) {
            int value = x % 10;
            x /= 10;
            rev = rev * 10 + value;
        }
        return (int)rev == rev? (int)rev : 0;
    }
}
