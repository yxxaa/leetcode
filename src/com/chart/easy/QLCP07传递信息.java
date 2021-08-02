package com.chart.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yxx
 * @date 2021/7/1 10:21
 * @Description:
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 *
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 *
 * 输出：3
 *
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * 示例 2：
 *
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 *
 * 输出：0
 *
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 */
public class QLCP07传递信息 {
    List<List<Integer>> list;
    int n, k, res;

    // 图+dfs
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        list = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int[] rela : relation) {
            int src = rela[0], tar = rela[1];
            list.get(src).add(tar);
        }
        dfs(0, 0);
        return res;
    }
    public void dfs(int index, int steps) {
        if (steps == k){
            if (index == n -1){
                res++;
            }
            return;
        }
        for (Integer r: list.get(index)) {
            dfs(r,steps +1);
        }
    }
    // 动态规划(不太懂)
    /*
    * 用i轮传递到达j号位的方案数位dp[i][j]
    *
    * */
    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}
