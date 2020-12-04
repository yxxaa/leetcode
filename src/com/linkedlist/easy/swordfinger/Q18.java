package com.linkedlist.easy.swordfinger;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/4 13:35
 * @Description: *删除链表的节点
 * @Difficulty: easy
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 */
public class Q18 {
    // 迭代法
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode cur = head;
        ListNode temp = head;
        while (temp.next.val != val) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return cur;
    }
    //递归
    public ListNode deleteNode2(ListNode head, int val) {
        if (head==null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode2(head.next,val);
        return head;
    }
}
