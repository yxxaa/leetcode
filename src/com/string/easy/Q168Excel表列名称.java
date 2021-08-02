package com.string.easy;

import java.util.HashMap;

/**
 * @author yxx
 * @date 2021/6/29 13:44
 * @Description: 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * <p>
 * 26进制
 * 1  2    4       8
 * 1  26 26*26  26*26*26
 * <p>
 * 52
 * az
 */
public class Q168Excel表列名称 {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char) ('A' + a0 - 1));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
}
