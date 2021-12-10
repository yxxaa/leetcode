package com.dfs.medium;

import com.dfs.Node;

import java.util.PrimitiveIterator;

/**
 * @author yxx
 * @date 2021/10/9 20:39
 * @Description:
 */
public class 剑指Offer36二叉搜索树与双向链表 {
    public Node pre,head;

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void dfs(Node root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre !=null) pre.right = root;
        else head = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }


}
