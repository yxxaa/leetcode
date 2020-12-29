package com.linkedlist.medium.normal;

import com.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/17 13:39
 * @Description: *链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 */
public class Q1019 {
    // 栈
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        //栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的
        //值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.empty() && list.get(stack.peek()) < list.get(i)) {
                //如果栈顶元素对应的值小于当前值，说明栈顶元素遇到了比他小的
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
    // 暴力
    public int[] nextLargerNodes2(ListNode head) {
        int[] temp = new int[10000+1];
        int i = 0;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode cur2 = cur;
            while (cur2!=null) {
                if (cur2.val>cur.val) {
                    break;
                } else {
                    cur2 =cur2.next;
                }
            }
            if (cur2==null) {
                temp[i] = 0;
            } else {
                temp[i] = cur2.val;
            }
            cur = cur.next;
            i++;
        }
        temp[i] = 0;
        int[] res = new int[i+1];
        System.arraycopy(temp, 0, res, 0, i+1);
        return res;
    }
}
