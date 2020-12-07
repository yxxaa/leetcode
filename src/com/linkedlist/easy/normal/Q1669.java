package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/6 13:48
 * @Description: *合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * 示例：
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 *
 */
public class Q1669 {
    //迭代法，需要更好的方法来解
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list1start = null;
        ListNode list1end = null;
        ListNode temp = list1;
        ListNode list2end = list2;
        int i=0;
        while (temp!=null) {
            if (i==a) {
                list1start = temp;
            }
            if (i==b) {
                list1end = temp;
            }
            temp = temp.next;
            i++;
        }
        while (list2end.next!=null) {
            list2end = list2end.next;
        }
        list1start.next = list2;
        list2end.next = list1end;
        return list1;
    }
}
