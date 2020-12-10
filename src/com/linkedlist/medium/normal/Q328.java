package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/10 13:27
 * @Description: *奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode evenHead = head.next,even = evenHead,odd = head;
        ListNode temp = head.next.next;
        int x = 1;
        while (temp!=null) {
            if (x%2==0) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
            x++;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}
