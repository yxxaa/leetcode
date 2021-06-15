package com.dynamicprogramming.medium;

/**
 * @author yxx
 * @date 2021/6/8 10:07
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Q343整数拆分 {
    public static void main(String[] args) {
        Q343整数拆分 q343整数拆分 = new Q343整数拆分();
        q343整数拆分.integerBreak(10);
    }

    /*拆分数字i的到最大乘机为dp[i]
     * */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        for (int s : dp) {
            System.out.println(s);
        }
        return dp[n];
    }
}
