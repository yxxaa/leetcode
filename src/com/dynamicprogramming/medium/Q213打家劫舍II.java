package com.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/6/28 14:44
 * @Description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *
 */
public class Q213打家劫舍II {
    public int rob(int[] nums) {
//        Q198打家劫舍 robClass = new Q198打家劫舍();
//        int n = nums.length;
//        int max1 = robClass.rob(Arrays.copyOfRange(nums, 0, n-1));
//        int max2 = robClass.rob(Arrays.copyOfRange(nums, 1, n));
//        return Math.max(max1,max2);
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int max1 = robM(Arrays.copyOfRange(nums, 0, n-1));
        int max2 = robM(Arrays.copyOfRange(nums, 1, n));
        return Math.max(max1,max2);
    }

    public int robM(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 到第i家时最大价值为dp[i]
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            // 是否偷这家，如果偷最大值为num[i]+dp[i-2] ,不偷就为dp[i-1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
