package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/7 14:56
 * @Description: *排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class Q148 {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head==null) {
            return head;
        }
        if (head.next==tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode listNode1 = sortList(head, mid);
        ListNode listNode2 = sortList(mid, tail);
        ListNode sorted = mergeTwoLists(listNode1, listNode2);
        return sorted;
    }
    //合并有序列表，同Q21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) {
            return l2;
        }else if(l2==null) {
            return l1;
        } else if (l1.val<=l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}
