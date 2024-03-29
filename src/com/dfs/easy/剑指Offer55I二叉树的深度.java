package com.dfs.easy;

import com.dfs.TreeNode;

/**
 * @author yxx
 * @date 2021/10/11 16:08
 * @Description:
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class 剑指Offer55I二叉树的深度 {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }
    public void dfs(TreeNode cur, int n) {
        if (cur == null) {
            max = Math.max(max, n);
            return;
        }
        dfs(cur.left,n+1);
        dfs(cur.right,n+1);
    }
}
