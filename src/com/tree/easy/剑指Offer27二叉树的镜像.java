package com.tree.easy;

import com.tree.TreeNode;

/**
 * @author yxx
 * @date 2021/9/29 11:15
 * @Description:
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *     4
 *   /  \
 *  2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 *
 *   4
 *  /  \
 *  7   2
 * / \  / \
 * 9  6 3 1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 */
public class 剑指Offer27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
