package com.linkedlist.Interviewquestions;

/**
 * @Author: yxx
 * @Date: 2020/12/2 11:08
 * @Description: *删除中间节点
 * @Difficulty: easy
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 */

import com.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q0203 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode node2 = new ListNode(3);
        listNode.next.next = node2;
        listNode.next.next.next = new ListNode(4);

        deleteNode(listNode);
        System.out.println(listNode);
    }

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
