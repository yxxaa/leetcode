package com.tree.medium;

import com.tree.TreeNode;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yxx
 * @date 2021/9/28 9:51
 * @Description:从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 */
public class 剑指Offer32I从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
