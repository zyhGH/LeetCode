package com.zyh.leetcode.simple;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Simple15 {
    public static void main(String[] args) {
        plusOne2(new int[]{1, 2, 3});
    }

    /**
     * 想一想就能想的出来 但是要考虑到溢出 千万不要用plusOne2
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }else {
            int temp = 1;
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i > -1; i--) {
                digits[i] = (digits[i] + temp) % 10;
                if (digits[i] % 10 != 0) {
                    temp = 0;
                }
            }
        }
        if (digits[0] == 0) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        } else {
            return digits;
        }
    }

    /**
     * 不能用这个方法 太长的数组会造成溢出
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        String parseInt = "" + (Long.parseLong(sb.toString()) + 1);

        int[] result = new int[parseInt.length()];
        for (int i = 0; i < parseInt.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(parseInt.charAt(i)));
        }
        return result;
    }
}
