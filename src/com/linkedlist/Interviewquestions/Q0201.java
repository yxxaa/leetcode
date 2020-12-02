package com.linkedlist.Interviewquestions;

import com.linkedlist.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yxx
 * @Date: 2020/12/2 16:43
 * @Description: *移除重复节点
 * @Difficulty: easy
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 *  示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 */
public class Q0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head==null) return head;
        ListNode cur = head;
        Set<Integer> set = new HashSet();
        set.add(head.val);

        while (cur.next != null) {
            ListNode temp = cur.next;
            if (set.add(temp.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;

    }
}
