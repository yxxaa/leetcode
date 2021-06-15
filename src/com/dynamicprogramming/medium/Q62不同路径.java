package com.dynamicprogramming.medium;

/**
 * @author yxx
 * @date 2021/6/7 16:49
 * @Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 */
public class Q62不同路径 {
    /**
     * 1. 确定dp数组以及下标的含义
     * dp[i][j]表示到达（i，j）位置时有多少种路径
     * 2. 确定递推公式
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 可以理解为（i,j）位置可以是它上面那个向下走一步或者左边那个向右走一步
     * 3. dp数组如何初始化
     * 一直横着走或者一直竖着走-》
     * dp[i][0] = 1;
     * dp[0][j] = 1;
     * 4. 确定遍历顺序
     * 前到后 上到下
     * 5. 举例推导dp数组
     *  1 1 1 1
     *  1 2 3 4
     *  1 3 6 10
     *  1 4 10 20
     *
     *
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化dp
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    // 滚动数组,优化空间复杂度。
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        // 初始化dp
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
