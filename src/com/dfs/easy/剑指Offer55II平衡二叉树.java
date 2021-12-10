package com.dfs.easy;

import com.dfs.TreeNode;

/**
 * @author yxx
 * @date 2021/10/16 15:03
 * @Description: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 */
public class 剑指Offer55II平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        return Math.max(height(cur.left), height(cur.right)) + 1;
    }
}
