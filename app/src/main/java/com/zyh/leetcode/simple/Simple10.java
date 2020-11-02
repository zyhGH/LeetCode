package com.zyh.leetcode.simple;

import android.util.Log;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Simple10 {
    public static void main(String[] args) {
        System.out.println(strStr3("mississippi", "ababcedzdecababab"));
    }

    /**
     * 不建议用 毕竟是算法题
     * 投机取巧
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i = haystack.indexOf(needle);
        return i;
    }


    /**
     * 这其实是indexOf的源码
     * 我修改了一下 变成我能理解的了
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        final int sourceLength = haystack.length();
        final int targetLength = needle.length();

        char first = needle.charAt(0);
        int max = sourceLength - targetLength;

        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) == first) {
                for (int j = 0; j < targetLength; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    } else {
                        if (j == targetLength - 1) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }


    /**
     * 尝试自己写一下kmp
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr3(String haystack, String needle) {     //abcdex
        int[] next = new int[needle.length()];
        next[0] = -1;   // 人为规定为-1
        next[1] = 0;    // 人为规定为0，因前面就一个字符，前后缀又不允许是字符串本身
        int i = 2;
        int p = 0;  //p为前缀的后一个字符位置
        while(i < needle.length()) {
            if(needle.charAt(i - 1) == needle.charAt(p)) {
                next[i] = p + 1;  // 匹配到的前缀长度（为前缀最后一个字符下标 + 1）
                p++;
                i++;
            }else {
                if(p == 0) {      // 你连第一个字符都不匹配，前后缀没有，next为0
                    next[i] = 0;
                    i++;
                }else {
                    p = next[p];  // 前缀还很长，发生不匹配不慌，再找更小的前缀试试
                }
            }
        }
        return 0;
    }
}
