package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;

import java.util.Arrays;

/**
 * @Author: yxx
 * @Date: 2020/12/11 15:53
 * @Description: *链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 *
 * 示例 1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 */
public class Q817 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        int[] G = new int[3];
        G[0] = 0;
        G[1] = 1;
        G[2] = 3;
        numComponents(l1,G);
    }
    public static int numComponents(ListNode head, int[] G) {
        ListNode curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = new ListNode(-1);
        curr = head;
        int res = 0;

        while (curr.next!=null) {
            if (isContain(curr.val,G)&& !isContain(curr.next.val,G)) {
                res++;
            }
            curr = curr.next;
        }
        return res;
    }
    public static boolean isContain(int x, int[] G){
        for (int i = 0;i<G.length;i++) {
            if (x==G[i]) {
                return true;
            }
        }
        return false;
    }
}
