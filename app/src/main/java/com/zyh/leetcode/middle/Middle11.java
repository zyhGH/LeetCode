package com.zyh.leetcode.middle;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Middle11 {
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1)
            return 0;
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1 + i; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }

    public int maxArea2(int[] height) {
        if (height.length == 0 || height.length == 1)
            return 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = 0;
        while (leftIndex < rightIndex) {
            result = Math.max(result, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] < height[rightIndex])
                leftIndex++;
            else
                rightIndex--;
        }
        return result;
    }
}
