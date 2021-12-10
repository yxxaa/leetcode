package com.recursion.medium;

/**
 * @author yxx
 * @date 2021/10/16 15:24
 * @Description: 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出:6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出:45
 */
public class 剑指Offer64求1加2加n {
    public int sumNums(int n) {
        return n > 0 ? n + sumNums(n - 1) : 0;
    }
}
