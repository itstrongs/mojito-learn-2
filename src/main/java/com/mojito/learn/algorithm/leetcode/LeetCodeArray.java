package com.mojito.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 力扣 - 数组
 *
 * @author liufengqiang
 * @date 2021-03-04 11:05:11
 */
public class LeetCodeArray {

    /**
     * 977. 有序数组的平方
     */
    public int[] sortedSquares(int[] nums) {
        // 简单平方后排序
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);

        //
        return result;
    }
}
