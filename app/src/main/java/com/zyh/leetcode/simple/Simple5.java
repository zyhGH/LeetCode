package com.zyh.leetcode.simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */



public class Simple5 {
    public static void main(String[] args) {

    }


    /**
     * 我本身的想法是先用第一个数比第二个数，然后拿到的结果在和下一个数对比
     * 最后选出公共前缀
     * 但是执行3ms 因为时间复杂度是O(i*j)
     *
     * 答案也是如此 但是答案只光走了一个循环 循环里只判断是不是相等
     * 没有进行任何复杂操作
     * 所以循环只看外层 时间复杂度为O(i)
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String common = strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < common.length() && j < strs[i].length(); j++) {
                if (common.charAt(j) == strs[i].charAt(j)) {
                    result.append(common.charAt(j));
                }else {
                    break;
                }
            }
            common = result.toString();
            result.replace(0, result.length(), "");
            if (common.equals("")) {
                break;
            }
        }
        return common;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }
}
