package com.dynamicprogramming.medium;

/**
 * @author yxx
 * @date 2021/10/4 14:17
 * @Description:
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 1 2 2 5 8 / 1 22 5 8 / 1 2 25 8 / 12 2 5 8 / 12 25 8
 *
 */
public class 剑指Offer46把数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(translateNum(18822));
    }
    public static int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i < str.length(); i++) {
            dp[i+1] = dp[i];
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                dp[i+1]++;
                dp[i+1] += dp[i-1];
            }
        }
        return dp[str.length()];
    }

    public static int translateNum2(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

}
