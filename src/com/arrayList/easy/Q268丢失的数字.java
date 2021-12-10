package com.arrayList.easy;

/**
 * @author yxx
 * @date 2021/11/6 9:58
 * @Description:
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 */
public class Q268丢失的数字 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            temp[nums[i]] = 1;
        }
        for (int i = 0; i < n + 1; i++) {
            if (temp[i]==0) return i;
        }
        return n;
    }
}
