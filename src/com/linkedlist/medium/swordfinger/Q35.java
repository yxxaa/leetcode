package com.linkedlist.medium.swordfinger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yxx
 * @Date: 2020/12/7 11:45
 * @Description: *复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 示例 1：
 *

 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class Q35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //哈希表
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while (cur!=null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    //拼接+拆分
    public Node copyRandomList2(Node head) {
        if (head==null) return null;
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        Node pre = head,res = head.next;
        while (cur.next!=null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
        return res;
    }
}

