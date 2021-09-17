package com.string.easy;

/**
 * @author yxx
 * @date 2021/9/7 9:27
 * @Description:
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 *1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 */
public class Q1221分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int count = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i)=='L' ? 1 : -1;
            if (count == 0){
                res++;
            }
        }
        return res;
    }
}
