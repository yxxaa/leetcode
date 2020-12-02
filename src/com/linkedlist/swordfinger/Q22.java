package com.linkedlist.swordfinger;


import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/2 13:10
 * @Description: *链表中倒数第k个节点
 * @Difficulty: easy
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class Q22 {
    //还可以用快慢指针的方式做，详情见面试题Q0202
    private ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode res = head;
        int count = 0;
        while (cur!=null) {
            count++;
            cur = cur.next;
        }
        count-= k;
        while (count-- > 0){
            res = res.next;
        }
        return res;
    }
}
