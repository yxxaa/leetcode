package com.dynamicprogramming.medium;

/**
 * @author yxx
 * @date 2021/6/11 14:51
 * @Description:
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 1、总和为i时组合个数为dp[i]
 * 2、dp[i]=dp[i-nums[j]] + dp[i]
 *
 */
public class Q377组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] =1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if (i-nums[j]>=0){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
