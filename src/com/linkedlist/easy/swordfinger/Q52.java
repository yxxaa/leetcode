package com.linkedlist.easy.swordfinger;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/4 13:26
 * @Description: * 两个链表的第一个公共节点
 * @Difficulty: easy
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 示例：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *

 */
public class Q52 {
    //双指针法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA==null?headB:tempA.next;
            tempB = tempB==null?headA:tempB.next;
        }
        return tempA;
    }
}
