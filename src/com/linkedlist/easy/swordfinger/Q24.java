package com.linkedlist.easy.swordfinger;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/2 14:31
 * @Description: *反转链表（与leetCode206相同）
 * @Difficulty: easy
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next =new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode res = reverseList2(listNode);
        System.out.println("finial");
    }
    //递归
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next ==null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
    //双指针
    public static ListNode reverseList2(ListNode head) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp!=null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }
}
