package com.tree.medium;

import com.tree.TreeNode;

/**
 * @author yxx
 * @date 2021/9/29 10:48
 * @Description:
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 */
public class 剑指Offer26树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) && (cur(A, B) || isSubStructure(A.left,B) || isSubStructure(A.right, B));
    }
    public boolean cur(TreeNode A, TreeNode B) {
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        } else {
            return cur(A.left,B.left) && cur(A.right,B.right);
        }
    }
}
