package com.dynamicprogramming.medium;

/**
 * @author yxx
 * @date 2021/10/1 15:53
 * @Description:
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票"一次"可能获得的最大利润是多少？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *
 */
public class 剑指Offer63股票的最大利润 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice> prices[i]){
                minPrice = prices[i];
            } else if (prices[i] - minPrice>maxProfit){
                maxProfit = prices[i] -minPrice;
            }
        }
        return maxProfit;
    }
}
