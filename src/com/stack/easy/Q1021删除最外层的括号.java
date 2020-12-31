package com.stack.easy;

import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/30 11:02
 * @Description: *
 */
public class Q1021删除最外层的括号 {
    // 栈
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() && c=='(') {
                stack.push(c);
            } else if (!stack.isEmpty() && c=='(') {
                stack.push(c);
                sb.append(c);
            }
            if (c==')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    // 直接遍历
    public String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }
}
