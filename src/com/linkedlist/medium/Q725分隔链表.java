package com.linkedlist.medium;

import com.linkedlist.ListNode;

import javax.crypto.Cipher;
import java.util.List;
import java.util.zip.CheckedOutputStream;

/**
 * @author yxx
 * @date 2021/9/22 9:15
 * @Description: 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 *  
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 */
public class Q725分隔链表 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        int quotient = count / k, remainder = count % k;
        curr = head;
        ListNode pre = curr;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k && curr!=null; i++) {
            res[i] = curr;
            int j = quotient + (i< remainder?1:0);
            for (int l = 1; l < j; l++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return res;
    }
}
