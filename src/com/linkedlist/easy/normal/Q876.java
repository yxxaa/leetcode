package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/2 16:27
 * @Description: *链表的中间结点
 * @Difficulty: easy
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 */
public class Q876 {
    // 快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
