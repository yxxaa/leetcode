package com.stack.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/29 20:38
 * @Description: *给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 */
public class Q402移掉K位数字 {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && stack.peekLast()>digit && k>0) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
