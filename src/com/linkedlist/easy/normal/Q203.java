package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/6 13:26
 * @Description: *移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Q203 {
    //迭代法
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        ListNode cur = head;
        while (cur.next!=null) {
            if (cur.next.val==val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        if (head.val==val) {
            head = head.next;
        }
        return head;
    }
    //递归法
    public ListNode removeElements2(ListNode head, int val) {
        if (head==null) {
            return null;
        }
        head.next = removeElements2(head.next,val);
        if (head.val==val) {
            return head.next;
        } else {
            return head;
        }
    }
}
