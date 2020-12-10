package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;
import com.linkedlist.Node;
import com.linkedlist.medium.swordfinger.Q35;

/**
 * @Author: yxx
 * @Date: 2020/12/10 16:23
 * @Description: *复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。
 *
 *同剑指offerQ35
 */
public class Q138 {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node curr = head;
        while (curr!=null) {
            Node temp = curr.next;
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = temp;
            curr = temp;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head.next;
        Node pre = head,res = head.next;
        while (curr.next!=null) {
            pre.next = pre.next.next;
            curr.next = curr.next.next;
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = null;
        return res;
    }
}
