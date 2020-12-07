package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/7 14:07
 * @Description: *两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class Q24 {
    //迭代法
    public ListNode swapPairs(ListNode head) {

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode temp = prev;
        while (temp!=null && temp.next!=null && temp.next.next!=null) {
            ListNode next1 = temp.next;//2
            ListNode next2 = temp.next.next;//3

            temp.next = next2;
            next1.next = next2.next;
            next2.next = next1;
            temp = next1;
        }
        return prev.next;
    }
    //递归法
    public ListNode swapPairs2(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(head.next.next);
        next.next = head;

        return next;
    }
}
