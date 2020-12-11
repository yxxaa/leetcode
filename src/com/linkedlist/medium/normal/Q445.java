package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;

import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/11 16:56
 * @Description: *两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1!=null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int c= 0;
        ListNode res = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || c>0) {
            int sum = (stack1.isEmpty()? 0:stack1.pop())+(stack2.isEmpty()? 0:stack2.pop())+c;
            ListNode n = new ListNode(sum % 10);
            c = sum/10;
            n.next = res;
            res = n;
        }
        return res;
    }
}
