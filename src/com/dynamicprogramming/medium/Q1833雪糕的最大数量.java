package com.dynamicprogramming.medium;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yxx
 * @date 2021/7/2 9:30
 * @Description: 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * 示例 2：
 * <p>
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 */
public class Q1833雪糕的最大数量 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        Arrays.stream(ints).reduce(0,(x, y) -> {
            System.out.println(x + y);
            return x + y;
        });
    }
    // 排序+贪心
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0, count = 0;
        for (int i : costs) {
            sum += i;
            if (sum > coins) {
                break;
            }
            count++;
        }
        return count;
    }
}
