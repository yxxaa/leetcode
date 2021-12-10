package com.dfs.easy;

import com.dfs.TreeNode;

/**
 * @author yxx
 * @date 2021/10/11 10:52
 * @Description:
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 */
public class 剑指Offer54二叉搜索树的第k大节点 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.right);
        if (k ==0) {
            return;
        }
        if (--k ==0){
            res = cur.val;
        }
        dfs(cur.left);
    }
}
