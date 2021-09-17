package com.arrayList.medium;

/**
 * @author yxx
 * @date 2021/8/10 9:25
 * @Description: 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 */
public class Q413等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int res = 0, t = 0;
        int s = nums[0] - nums[1];
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == s) {
                t++;
            } else {
                t = 0;
                s = nums[i - 1] - nums[i];
            }
            res += t;
        }
        return res;
    }
}
