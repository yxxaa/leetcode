package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/4 14:01
 * @Description: 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 */
public class Q160 {
    //双指针
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA==null?headB:tempA.next;
            tempB = tempB==null?headA:tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode5.next = listNode6;
        listNode6.next = listNode2;
        ListNode res = getIntersectionNode2(listNode1,listNode5);
        System.out.println("sdfasdf");
    }
    //获取两个链表的长度，让长的那个先走几步，然后一起循环
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA<=lengthB){
            int i = lengthB-lengthA;
            while (i-->0) {
                headB = headB.next;
            }
        } else {
            int i = lengthA-lengthB;
            while (i-->0) {
                headA = headA.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public static int getLength(ListNode head){
        ListNode cur = head;
        int i = 0;
        while (cur!=null) {
            cur = cur.next;
            i++;
        }
        return i;
    }
}
