package com.dfs.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxx
 * @date 2021/9/29 14:56
 * @Description:给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 */
public class Q78子集 {
    public static void main(String[] args) {
        Q78子集 obj = new Q78子集();
        List<List<Integer>> subsets = obj.subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }


    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            t.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j))!=0){
                    t.add(nums[j]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

}
