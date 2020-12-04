package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yxx
 * @Date: 2020/12/4 14:31
 * @Description: *删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class Q83 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        ListNode res = deleteDuplicates(listNode1);
        System.out.println("Sdfsd");
    }

    //哈希表
    //执行用时：1 ms, 在所有 Java 提交中击败了57.33%的用户
    //内存消耗：37.6 MB, 在所有 Java 提交中击败了94.79%的用户
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode temp = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (temp!=null && temp.next!=null) {
            if (set.add(temp.next.val)) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
                // temp = temp.next;这行不能有
            }
        }
        return head;
    }
    // 由于是顺序的直接比next就行
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode temp = head;
        while (temp!=null && temp.next!=null) {
            if (temp.val==temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

}
