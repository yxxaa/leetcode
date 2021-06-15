package com.recursion.easy;

/**
 * @author yxx
 * @date 2021/6/3 15:16
 * @Description: 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 */
public class Q1137第N个泰波那契数 {
    public int tribonacci(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }
        int pre1 = 0, pre2 = 1, pre3 = 1;
        for (int i = 2; i < n; i++) {
            int temp = pre1;
            pre1 = pre2;
            pre2 = pre3;
            pre3 = temp + pre1 + pre2;

        }
        return pre3;
    }
}
