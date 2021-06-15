package com.dynamicprogramming.medium;

/**
 * @author yxx
 * @date 2021/6/7 14:56
 * @Description: 爬楼梯。需要n阶才能爬到顶。一次只能爬1阶或者2阶。
 * 问有多少种方法可以爬到顶
 * 1 1   1
 * 2 2   11 2
 * 3 3   111 12 21
 * 4 5   1111 121 211 112 22
 * 5 8   1111 1211 2111 1121 221 122 212 1112
 * 可以看出到第i层的方法数可以是i-1层再跨一步或者第i-2层再跨两步
 * f(i) = f(i-1)+f(i-2)
 */
public class Q跳台阶 {
    public static void main(String[] args) {
        Q跳台阶 q跳台阶 = new Q跳台阶();
        q跳台阶.jumpStep(5);
    }

    public int jumpStep(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        for (int t : dp) {
            System.out.println(t);
        }
        return dp[n - 1];
    }
}
