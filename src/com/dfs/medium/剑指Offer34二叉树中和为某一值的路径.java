package com.dfs.medium;

import com.dfs.TreeNode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yxx
 * @date 2021/10/9 20:20
 * @Description:
 */
public class 剑指Offer34二叉树中和为某一值的路径 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return res;
    }
    public void dfs (TreeNode root, int target){
        if (root==null){
            return;
        }
        temp.offerLast(root.val);
        target-=root.val;
        if (root.left==null && root.right == null && target ==0){
            res.add(new ArrayList<>(temp));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        temp.pollLast();
    }
}
