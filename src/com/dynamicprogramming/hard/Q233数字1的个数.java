package com.dynamicprogramming.hard;

/**
 * @author yxx
 * @date 2021/8/13 9:38
 * @Description:
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：6
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 2 * 109
 *
 */
public class Q233数字1的个数 {

    public int countDigitOne(int n) {
        int old = 0,res = 0;
        for (int i = 1; i <= n; i++) {
            res = old + findOne(i);
            old = res;
        }
        return res;
    }
    public int findOne(int n){
        int count = 0;
        for (char a: String.valueOf(n).toCharArray()) {
            if (a == '1'){
                count++;
            }
        }
        return count;
    }
}
