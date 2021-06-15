package com.arrayList.easy;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/6/4 9:52
 * @Description:
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 *
 * 注意：中心下标可能出现在数组的两端。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 *示例 2：
 *
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 *
[1,7,3,6,5,6]
输出
-1 4
预期结果
3
 */
public class Q724寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            right +=nums[i];
        }
        if (left == right) return 0;
        for (int i = 1; i < nums.length; i++) {
            left += nums[i-1];
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
