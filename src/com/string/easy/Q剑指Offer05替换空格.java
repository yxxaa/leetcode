package com.string.easy;

import java.util.logging.Level;

/**
 * @author yxx
 * @date 2021/9/25 15:13
 * @Description:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class Q剑指Offer05替换空格 {
    public String replaceSpace(String s) {
        int n = s.length();
        int size = 0;
        char[] chars = new char[n*3];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)==' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = s.charAt(i);
            }
        }
        return new String(chars,0,size);
    }
}
