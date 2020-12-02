package com.linkedlist.swordfinger;

import com.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/2 13:47
 * @Description: * 从尾到头打印链表
 * @Difficulty: easy
 */
public class Q06 {
    // 使用栈的方法
    // 执行用时：1 ms, 在所有 Java 提交中击败了72.28%的用户
    // 内存消耗：39.1 MB, 在所有 Java 提交中击败了74.93%的用户
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    // 使用递归
    // 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    // 内存消耗：39.9 MB, 在所有 Java 提交中击败了10.73%的用户
    static int[] res;
    static int i;
    public int[] reversePrint2(ListNode head) {
        recur(head,0);
        return res;
    }
    public static void recur(ListNode head, int count){
        if (head == null) {
            res = new int[count];
            i = count-1;
            return;
        }
        recur(head.next,count+1);
        res[i-count] = head.val;//精髓i-count
    }
}
