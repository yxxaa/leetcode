package com.linkedlist.Interviewquestions;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/2 13:38
 * @Description: 返回倒数第 k 个节点
 * @Difficulty: easy
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 */
public class Q0202 {
    //使用双指针方法
    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (k-->0) {
            first = first.next;
        }
        while (first!=null) {
            first = first.next;
            second = second.next;
        }
        return second.val;
    }
}
