package com.linkedlist.easy.normal;

import com.linkedlist.ListNode;

/**
 * @Author: yxx
 * @Date: 2020/12/4 15:08
 * @Description: *环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 示例：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Q141 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        boolean flag = hasCycle(listNode1);
        System.out.println("SDf");
    }
    // 快慢指针
    public static boolean hasCycle(ListNode head) {
        if (head.next==null || head==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next.next;
        slow = slow.next;
        while (fast != slow && slow!=null && fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast==slow?true:false;
    }
    //哈希表
}
