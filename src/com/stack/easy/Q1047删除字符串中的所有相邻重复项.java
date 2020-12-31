package com.stack.easy;

import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/30 11:24
 * @Description: *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 */
public class Q1047删除字符串中的所有相邻重复项 {
    // 执行用时：31 ms, 在所有 Java 提交中击败了44.38%的用户
    // 内存消耗：39.1 MB, 在所有 Java 提交中击败了65.97%的用户
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.size()>0 && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    // 执行用时：19 ms, 在所有 Java 提交中击败了67.52%的用户
    // 内存消耗：39.1 MB, 在所有 Java 提交中击败了62.23%的用户
    public String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (char c : S.toCharArray()) {
            if (stack.size()>0 && stack.peek() == c) {
                stack.pop();
                sb.delete(index, index+1);
                index--;
            } else {
                stack.push(c);
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }
    //执行用时：11 ms, 在所有 Java 提交中击败了84.25%的用户
    //内存消耗：39.2 MB, 在所有 Java 提交中击败了50.45%的用户
    public String removeDuplicates3(String S) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (char c : S.toCharArray()) {
            if (sb.length()>0 && sb.charAt(index)==c) {
                sb.deleteCharAt(index);
                index--;
            } else {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }
}
