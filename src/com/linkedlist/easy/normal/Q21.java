package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/3 16:17
 * @Description: *合并两个有序链表
 * @Difficulty: easy
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Q21 {
    //迭代法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val<=l2.val) {
                pre.next=l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
        return prehead.next;
    }
    //递归法。
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1==null) {
            return l2;
        }else if(l2==null) {
            return l1;
        } else if (l1.val<=l2.val) {
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l2.next,l1);
            return l2;
        }
    }

}
