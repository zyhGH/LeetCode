package com.zyh.leetcode.simple;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Simple14 {
    /**
     * 没什么说的 挺简单的题
     * 从后往前遍历 去掉空格就ok 再遇到空格就是一个词
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = 0;
        for (int i = s.length() - 1; i > -1 ; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            if (s.charAt(i) == ' ' && length != 0) {
                return length;
            }
        }
        return length;
    }
}
