package com.math.medium;

/**
 * @author yxx
 * @date 2021/6/1 13:26
 * @Description:
 * 给你一个下标从 0 开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。
 * 同时给你一个二维数组queries，其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第0天开始吃糖果。
 * 你在吃完 所有第 i - 1类糖果之前，不能吃任何一颗第 i类糖果。
 * 在吃完所有糖果之前，你必须每天 至少吃 一颗糖果。
 * 请你构建一个布尔型数组answer，满足answer.length == queries.length 。answer[i]为true的条件是：
 * 在每天吃 不超过 dailyCapi颗糖果的前提下，你可以在第favoriteDayi天吃到第favoriteTypei类糖果；
 * 否则 answer[i]为 false。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组answer。
 *
 * 示例 1：
 *
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 *
 * [7,4,5,3,8]
 * [[0,2,2],[4,2,4],[2,13,1000000000]]
 * [true,false,true]
 * [7,11,5,3,8]
 * [[2,2,6],[4,2,4],[2,13,1000000000]]
 * [false,false,true]
 */
public class Q1744你能在你最喜欢的那天吃到你最喜欢的糖果吗 {
    public static void main(String[] args) {
        System.out.println(canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}}));
    }
    // 核心思想就是判断两个区间有没交集
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        boolean[] res = new boolean[n];
        int[] sum = new int[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i-1] + candiesCount[i];
        }
        for (int i = 0; i < n; i++) {
            int favoriteType = queries[i][0], favoriteDay =queries[i][1], dailyCap = queries[i][2];
            long x1 = favoriteDay + 1; //最少吃多少个
            long y1 = (long) (favoriteDay + 1) * dailyCap; // 最多吃多少个
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1; // 到目标种类糖的前一个有多少个
            long y2 = sum[favoriteType]; // 到目标种类的糖有多少个

            res[i] = !(x1 > y2 || y1 < x2);
        }
        return res;
    }

}
