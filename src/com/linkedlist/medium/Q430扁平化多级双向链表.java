package com.linkedlist.medium;

import com.linkedlist.Node;
import com.linkedlist.Node2;

/**
 * @author yxx
 * @date 2021/9/24 10:12
 * @Description:
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 *
 */
public class Q430扁平化多级双向链表 {
    public Node2 flatten(Node2 head) {
        dfs(head);
        return head;
    }
    public Node2 dfs(Node2 node) {
        Node2 cur = node;
        Node2 last = null;
        while (cur!=null) {
            Node2 next = cur.next;
            if (cur.child !=null){
                Node2 childLast = dfs(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;

                if (next!=null){
                    childLast.next = next;
                    next.prev = childLast;
                }

                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
