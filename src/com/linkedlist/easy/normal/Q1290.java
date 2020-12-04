package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/2 11:37
 * @Description: *二进制链表转整数
 * @Difficulty: easy
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 */
public class Q1290 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(1);

        System.out.println(getDecimalValue(listNode));
    }
    public static int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            res = res*2 + cur.val;
            cur = cur.next;
        }
        return res;
    }

}
