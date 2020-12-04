package com.linkedlist.easy.Interviewquestions;

import com.linkedlist.ListNode;

import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/4 15:47
 * @Description: *
 */
public class Q0206 {
    //栈
    //执行用时：4 ms, 在所有 Java 提交中击败了24.85%的用户
    //内存消耗：42.2 MB, 在所有 Java 提交中击败了35.42%的用户
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur!=null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ListNode temp = head;
        while (temp!=null) {
            if (stack.pop()!=temp.val){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    //快慢指针，反转后一半链表
    //执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
    //内存消耗：41.1 MB, 在所有 Java 提交中击败了78.03%的用户
    public static boolean isPalindrome2(ListNode head) {
        if (head==null||head.next==null) return true;
        ListNode cur = head;
        ListNode mid = getMid(cur);
        mid.next = reverse(mid.next);
        while (mid.next!=null) {
            if (mid.next.val != cur.val) {
                return false;
            }
            mid = mid.next;
            cur = cur.next;
        }
        return true;
    }
    public static ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&& fast.next!=null &&fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp!=null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }
}
